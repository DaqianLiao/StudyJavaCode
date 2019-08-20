
package com.ldq.study.util.lang3;

import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.lang3.math.IEEE754rUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static java.lang.System.out;

public class MathTest {
    @Test
    public void fraction() throws Exception {
        Fraction fraction = Fraction.getFraction(3, 1, 2);
        out.println(fraction.doubleValue());
        Fraction fraction1 = Fraction.getFraction(2, 1, 2);
        Fraction multiply = fraction.multiplyBy(fraction1);
        out.println(multiply.doubleValue());
        Fraction add = fraction.add(fraction1);
        out.println(add.doubleValue());
        Fraction pow = fraction.pow(2);
        out.println(pow.doubleValue());
        Fraction invert = fraction.invert();
        out.println(invert.toProperString());
    }

    @Test
    public void IEEE754r() throws Exception {
        //加入了对NaN的支持
        try {
            float min = IEEE754rUtils.min(1f, 0f / 0f);
            out.println("ieee754: " + min);
        } catch (Exception e) {
            out.println("error");
        }

        try {
            float min = Math.min(1f, 0f / 0f);
            out.println(min);
        } catch (Exception e) {
            out.println("error");
        }
    }

    @Test
    public void number() throws Exception {
        //对字符串转数的支持
        int i = NumberUtils.toInt("23");
        out.println("toInt:" + i);
        long l = NumberUtils.toLong("23");
        out.println("toLong:" + l);
        //三个和数组大小比较
        int min = NumberUtils.min(1, 2, 3);
        out.println("min:" + min);
        int max = NumberUtils.max(1, 2, 3);
        out.println("max:" + max);
        //isCreatable判断是否是合法的java number，包括16进制数，8进制数，科学记数法，有类型标注的数（比如0L,8D等）
        //isParsable是否可转成数，不包含十六进制和科学计数法
        //isDigit是否都是数字

        //生成数
        Number number = NumberUtils.createNumber("0x36");
        out.println(number.getClass().getName() + ":" + number.intValue());
        //比较整型数的大小，java7里面也有支持
        int compare = NumberUtils.compare(4, 7);
        out.println(compare);
        int java7 = Integer.compare(4, 7);
        out.println(java7);
    }
}

