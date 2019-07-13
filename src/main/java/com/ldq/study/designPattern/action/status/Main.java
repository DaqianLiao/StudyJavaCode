package com.ldq.study.designPattern.action.status;

public class Main {

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
