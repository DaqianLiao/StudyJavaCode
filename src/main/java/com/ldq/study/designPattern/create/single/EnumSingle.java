package com.ldq.study.designPattern.create.single;

/**
 * 利用枚举实现创建单例，线程安全
 * 自动支持序列化机制，绝对防止多次实例化
 * 不能通过反射攻击类调用私有构造方法
 * 最简洁最安全的单例模式，使用较少
 * 枚举类型已经继承了java.lang.Enum，所以，其他类不能继承枚举（java单继承特性）
 */
public enum EnumSingle {
    ENUM_SINGLE;

    public void method(){
        System.out.println("内部方法");
    }
}
