package com.ldq.study.finalDemo;

/**
 * final修饰变量会指向一块固定的内存，这个内存中的值不允许改变
 * final修饰的常量，在编译阶段会放到常量池中
 * final修饰方法，主要是锁住父类方法，不允许任何继承类对该方法进行修改，参考模版模式中的模版方法
 * final修饰类，表明该类不能被继承，参考String类
 */
public class Main {
    public static void testPerson(){
        Person p = new Person("Lily","girl",25);
        System.out.println("p = " +p);

        Person pp = new Person("Lucy","girl",20);
        System.out.println("pp = " +pp);

        p = pp;
        System.out.println("set pp = p! p = " + p);
    }

    /**
     * final修饰的引用类型变量，引用类型变量的地址不允许改变，
     * 但是引用变量的成员变量的值可以改变
     */
    public static void testFinalPerson(){
        final Person p = new Person("Lily","girl",18);
        System.out.println(p);
        p.setAge(25);
        System.out.println("change age! p = "+ p);
        System.out.println(p);
        Person pp = new Person("Lucy","girl",20);
        System.out.println(pp);

//        编译就会报错
//        p = pp;

    }

    /**
     * final修饰常量，对比StringBuilderJavaP中的方法
     */
    public static void testFinalConstant(){

        System.out.println("final 常量例子");
        //普通常量
        int n1 = 2019;
        //final修饰常量，进入常量池
        final int n2 = 2019;

        //拼接字符串
        String s = "20190708";
        String s1 = n1 + "0708";
        String s2 = n2 + "0708";
        System.out.println(s==s1);//参考stringBuilder模式
        System.out.println(s==s2);//对比noBuilder模式
    }

    public static void main(String[] args) {

        testPerson();
        testFinalPerson();
        testFinalConstant();
    }
}
