package com.ldq.study.util.lang3;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.junit.Test;

import static java.lang.System.out;

public class TupleTest {
    @Test
    public void mutablePair() throws Exception {
        MutablePair<Integer, String> mutablePair = MutablePair.of(new Integer(1), "zlb");
        out.println(mutablePair.toString());
        mutablePair.setValue("yqh");
        out.println(mutablePair.toString());
    }

    @Test
    public void triple() throws Exception {
        MutableTriple<Integer, String, String> mutableTriple = MutableTriple.of(new Integer(1), "zhang", "liangbo");
        out.println(mutableTriple.toString());
        mutableTriple.setMiddle("yang");
        mutableTriple.setRight("qinghui");
        out.println(mutableTriple.toString());
    }
}
