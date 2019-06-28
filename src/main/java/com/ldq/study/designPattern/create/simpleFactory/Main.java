package com.ldq.study.designPattern.create.simpleFactory;

public class Main {

    public static void main(String[] args) throws Exception {
        Operation add = OpertaionSimpleFac.createOperation("+");
        Operation sub = OpertaionSimpleFac.createOperation("-");
        Operation mul = OpertaionSimpleFac.createOperation("*");
        Operation div = OpertaionSimpleFac.createOperation("/");
        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
        System.out.println(div.getResult(1, 1));

        try {
            System.out.println(div.getResult(1, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Operation exception = OpertaionSimpleFac.createOperation("&");
            System.out.println(exception.getResult(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
