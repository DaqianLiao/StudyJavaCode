package com.ldq.study.gc.classLoader.analyse.fieldAnalyse;

/**
 * java类只能单继承
 * 因此不存在集成多个类的情况，
 * 所以只能循环递归找父类，直到第一次找到了字段A的值就返回
 */
public class FieldMultiObject {
    static class GrandPa {
        public static int A = 10;
    }

    static class Pa {
        public static int A = 20;
    }

    static class Pa0 extends GrandPa {
    }

    static class Pa1 extends GrandPa {
        public static int A = 21;
    }

    static class Son {
        public static int A = 30;
    }

    static class Son0 extends Pa0 {
    }

    static class Son01 extends Pa1 {
    }

    public static void main(String[] args) {
        //Pa中就有A，直接返回
        System.out.println("Pa.A = " + Pa.A);
        //Pa中没有A，父类中存在，返回
        System.out.println("Pa0.A = " + Pa0.A);
        //Pa中有，父类中也有，优先返回本类的值
        System.out.println("Pa1.A = " + Pa1.A);
        //本类中没有，父类没有，祖父类中有，
        //一直递归找到字段A
        System.out.println("Son0.A = " + Son0.A);
        //本类没有，父类和祖父类有
        //优先返回父类结果
        System.out.println("Son01.A = " + Son01.A);

    }

}
