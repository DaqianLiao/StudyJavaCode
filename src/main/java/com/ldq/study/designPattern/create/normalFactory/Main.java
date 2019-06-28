package com.ldq.study.designPattern.create.normalFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        Factory addFac = (Factory) Class.forName("com.ldq.study.designPattern.create.normalFactory.AddFactory").newInstance();
        Factory subFac = (Factory) Class.forName("com.ldq.study.designPattern.create.normalFactory.SubFactory").newInstance();
        Factory mulFac = (Factory) Class.forName("com.ldq.study.designPattern.create.normalFactory.MulFactory").newInstance();
        Factory divFac = (Factory) Class.forName("com.ldq.study.designPattern.create.normalFactory.DivFactory").newInstance();

        System.out.println(addFac.createOperation().getResult(1, 1));
        System.out.println(subFac.createOperation().getResult(1, 1));
        System.out.println(mulFac.createOperation().getResult(1, 1));
        System.out.println(divFac.createOperation().getResult(1, 1));
        try {
            System.out.println(divFac.createOperation().getResult(1, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
