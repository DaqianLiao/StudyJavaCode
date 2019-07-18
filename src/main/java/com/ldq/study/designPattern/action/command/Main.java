package com.ldq.study.designPattern.action.command;

/**
 * 命令模式：
 * 将请求封装成命令，具体命令有接受者执行
 * 优点： 实现了客户端和接受端之间的解耦
 *      可以动态的添加新命令
 * 缺点：实现具体的命令系统，需要创建大量命令对象
 *
 */
public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        OnCmdImpl on = new OnCmdImpl(receiver);
        OffCmdImpl off = new OffCmdImpl(receiver);

        Invoker invoker = new Invoker();
        invoker.execute(on);
        invoker.execute(off);
    }
}
