package com.ldq.study.gc.oom;

/**
 * 虚拟机栈的最小大小设置为 160K -Xss160k
 */
public class StackOverFlowDemo {
    private int deep = 0;

    public void test(){
        deep++;
        test();
    }

    public static void main(String[] args) {
        StackOverFlowDemo stack = new StackOverFlowDemo();

//        计算每个虚拟机栈帧大小，占用多少个字节
//        double val = 160*1024 / 772;
//        System.out.println("val = " + val);

        try{
            stack.test();
//        } catch (Throwable e){
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("stack.deep = " + stack.deep);
        }

    }
}
