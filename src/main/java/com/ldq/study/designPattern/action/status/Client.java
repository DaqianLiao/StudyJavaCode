package com.ldq.study.designPattern.action.status;

public class Client {

    private static void testState() {

        Context context = new Context();

        StartStateImpl startState = new StartStateImpl();
        startState.doAction(context);

        StopStateImpl stopState = new StopStateImpl();
        stopState.doAction(context);
    }

    public static void main(String[] args) {
        testState();
    }


}
