package com.ldq.study.serializable.kryo;

import java.util.Arrays;

public class KryoMain {

    public static void main(String[] args) {

        Serializer ser = new KryoSerializer(Msg.class);
        for (int i = 0; i <3; i++) {

            Msg msg = new Msg();
            msg.name="age";
            msg.code =  3;
            msg.age=i;
            byte[] bytes ;
            long start = System.nanoTime();
            bytes = ser.serialzer(msg);
            System.err.println("序列化耗时：" + (System.nanoTime() - start));
            System.out.println("msg = " + msg);
            System.out.println(Arrays.toString(bytes));

            Msg newmsg = null;
            start = System.nanoTime();
            newmsg = ser.deserializer(bytes);
            System.err.println("反序列化耗时：" + (System.nanoTime() - start));
            System.out.println("newmsg = " + newmsg);
        }
    }

}
