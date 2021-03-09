package com.ldq.study.util;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void map() {
        Optional<String> op = Optional.of("string");
        System.out.println("op.get() = " + op.get());
        Object str = op.map(x -> x.toUpperCase())
                .orElseGet(() -> "null");
        System.out.println("str = " + str);

        Object aNull = op.map(x -> x.toUpperCase())
                .map(x -> null)
                .orElseGet(() -> "null");

        System.out.println("aNull = " + aNull);
    }
}

