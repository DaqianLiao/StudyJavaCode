package com.ldq.study.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

public class UnsafeCase {

    private static final sun.misc.Unsafe unsafe;
    private static final long TBASE;
    private static final int TSHIFT;

    static {
        int ts;
        try {
            unsafe = getUnsafe();
            TBASE = unsafe.arrayBaseOffset(String[].class);
            ts = unsafe.arrayIndexScale(String[].class);
            System.out.println("ts = " + ts);
            System.out.println("TBASE = " + TBASE);
        } catch (Exception e) {
            throw new Error(e);
        }
        TSHIFT = 31 - Integer.numberOfLeadingZeros(ts);
    }

    static Unsafe getUnsafe() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe)f.get(null);
        return unsafe;
    }

    @SuppressWarnings("unchecked")
    static final String entryAt(String[] tab, int i) {
        return (String) unsafe.getObjectVolatile(tab, ((long)i << TSHIFT) + TBASE);
    }

    /**
     * park():方法返回条件
     * 1 当前现在调用过 unpark 方法 (多次调用 按照一次计算)
     * 2 当前线程被中断
     * 3 当park 为 false:时间块到了 单位纳秒
     * 4 当park 为 true:时间是绝对时间（1970）年 到期 单位毫秒
     */
    public static void function6() {
        System.out.println("Start");
        long time = System.currentTimeMillis()+3000l;
        unsafe.park(true,time);
        System.out.println("end");
    }

    /**
     * CAS操作
     * @throws Exception
     */
    @Test
    public void function5() throws Exception {

        Player player = (Player) unsafe.allocateInstance(Player.class);

        Field age = player.getClass().getDeclaredField("age");

        long addressAge = unsafe.objectFieldOffset(age);

        System.out.println("addressAge = " + addressAge);
        unsafe.compareAndSwapInt(player, addressAge, 0, 100);

        System.out.println(player.getAge());

    }


    /**
     * 直接分配内存地址：内存管理
     */
    @Test
    public void function4() {
        //分配100字节内存  返回初始地址
        long address = unsafe.allocateMemory(100);
        System.out.println("address = " + address);
        //往分配的内存地址写入值
        unsafe.putInt(address, 55);
        //获取值
        System.out.println(unsafe.getInt(address));

        //分配100字节内存  返回初始地址
        long address1 = unsafe.allocateMemory(100);
        System.out.println("address1 = " + address1);
        //copy 内存值
        unsafe.copyMemory(address, address1, 4);

        System.out.println(unsafe.getInt(address1));

        //释放内存
        unsafe.freeMemory(address);
        unsafe.freeMemory(address1);

    }


    /**
     * 操作对象属性值
     * @throws Exception
     */
    public static void function3() throws Exception {

        Player player = (Player) unsafe.allocateInstance(Player.class);

        Field fieldName = player.getClass().getDeclaredField("name");

        Field fieldAge = player.getClass().getDeclaredField("age");

        long fileNameaddres = unsafe.objectFieldOffset(fieldName);

        long fileAgeaddres = unsafe.objectFieldOffset(fieldAge);

        unsafe.putObjectVolatile(player, fileNameaddres, "wangWu");

        unsafe.putInt(player,fileAgeaddres, 100);

        System.out.println(player);

    }


    /**
     * 实例化对象
     * @throws InstantiationException
     */
    @Test
    public void function2() throws InstantiationException {

        Player player = (Player) unsafe.allocateInstance(Player.class);

        player.setAge(100);

        player.setName("zhangShan");

        System.out.println(player);
    }

    /**
     * 对数组的操作
     */
    @Test
    public void function1() {
        int[] num = new int[7];

        //数组的起始地址
        long adress = unsafe.arrayBaseOffset(int[].class);
        //block 大小
        long index = unsafe.arrayIndexScale(int[].class);

        System.out.println("adress = " + adress);
        System.out.println("index = " + index);
        unsafe.putInt(num, adress,1);
        unsafe.putInt(num, adress+index, 2);
        unsafe.putInt(num, adress+index+index, 3);
        unsafe.putInt(num, adress+index+index+index, 4);

        System.out.println("num = " + Arrays.toString(num));
    }
    public static void main(String[] args) {
        int nLen = 37;
        String[] table = new String[nLen];
        for (int i = 0; i < nLen; i++) {
            table[i] = "数值为:  " + String.valueOf(i + 26);
        }
        String str = entryAt(table, 23);
        System.out.println(str);
    }
}
