package com.ldq.study.gc.byteCodeAnaliyse;

/**
 * 查看这段代码的字节码：
 * 1/编译同包的Main方法，会编译该段代码
 * 2/在该类中，点击右键->external tools->show byte code
 * 3/就能查看到这段代码编译的字节码
 *
 */
public class ByteCodeStruct {
    private int m;

    public int inc() {
        return m + 1;
    }
}
