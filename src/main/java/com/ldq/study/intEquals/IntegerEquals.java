package com.ldq.study.intEquals;

//-XX:AutoBoxCacheMax = 150
public class IntegerEquals {

    public static void main(String[] args) {
        Integer n1 = 123;
        Integer n2 = 123;

        Integer n5 = 150;
//        Integer n6 = 150;
        Integer n6 = new Integer(150);
        int n7 = 150;
        int n8 = new Integer(150);
        System.out.println(n1 == n2);
        System.out.println(n5 == n6);
        System.out.println(n5 == n7);
        System.out.println(n6 == n8);
        System.out.println(n7 == n8);

    }


}