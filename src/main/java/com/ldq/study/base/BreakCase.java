package com.ldq.study.base;

import org.junit.Test;

public class BreakCase {

    @Test
    public void oneLoopCase() {
//        break 会跳出循环
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.print("\n");
                System.out.println("inner print i = " + i);
                break;
            }
            System.out.print("inner " + i + "; ");
        }
    }

    @Test
    public void twoLoopCase() {
//        break只会跳出内层循环
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    System.out.print("\n");
                    System.out.println("inner print i = " + i);
                    break;
                }
                System.out.print("inner " + i + "; ");
            }
        }
    }


    @Test
    public void twoLoopSignCase() {
//        设置跳出标签，这样break就能跳出多层循环了
        sgin:
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    System.out.print("\n");
                    System.out.println("inner print i = " + i);
                    break sgin;
                }
                System.out.print("inner " + i + "; ");
            }
        }
    }
}
