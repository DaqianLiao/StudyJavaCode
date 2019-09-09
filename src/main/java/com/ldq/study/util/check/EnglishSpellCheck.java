package com.ldq.study.util.check;

import com.github.houbb.word.checker.core.impl.EnWordChecker;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * https://www.jianshu.com/p/886edf1917fc
 * <p>
 * 功能	方法	参数	返回值	备注
 * 判断单词拼写是否正确	isCorrect(string)	待检测的单词	boolean
 * 返回最佳纠正结果	    correct(string)	    待检测的单词	String	        如果没有找到可以纠正的单词，则返回其本身
 * 判断单词拼写是否正确	correctList(string)	待检测的单词	List<String>	返回所有匹配的纠正列表
 * 判断单词拼写是否正确	correctList(string, int limit)	待检测的单词, 返回列表的大小	返回指定大小的的纠正列表	列表大小 <= limit
 */
public class EnglishSpellCheck {

    public static void main(String[] args) {
        String result = EnWordChecker.getInstance().correct("speling");
        System.out.println(result);
    }

    /**
     * 是否拼写正确
     */
    @Test
    public void isCorrectTest() {
        String hello = "hello";
        String speling = "speling";
        EnWordChecker instance = EnWordChecker.getInstance();
        System.out.println(instance.correct(hello));
        System.out.println(instance.correct(speling));
        Assert.assertTrue(EnWordChecker.getInstance().isCorrect(hello));
        Assert.assertFalse(EnWordChecker.getInstance().isCorrect(speling));
    }

    /**
     * 返回最佳匹配结果
     */
    @Test
    public void correctTest() {
        String hello = "hello";
        String speling = "speling";
        EnWordChecker instance = EnWordChecker.getInstance();
        System.out.println(instance.correct(hello));
        System.out.println(instance.correct(speling));
        Assert.assertEquals("hello", instance.correct(hello));
        Assert.assertEquals("spelling", instance.correct(speling));
    }

    /**
     * 默认纠正匹配列表
     * 1. 默认返回所有
     */
    @Test
    public void correctListTest() {
        String word = "goo";
        List<String> stringList = EnWordChecker.getInstance().correctList(word);
        System.out.println(stringList);
        Assert.assertTrue(stringList.size() > 0);
    }


}
