package com.ldq.study.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void createStream() {
        // 1. Collection 提供了两个方法 stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        // 2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);
        stream1.forEach(System.out::println);

        // 3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);
        stream2.forEach(System.out::println);

        // 4. 创建无限流 - 迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(20);
        stream3.forEach(System.out::println);

        // 5. 创建无限流 - 生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(5);
        stream4.forEach(System.out::println);
    }

    public static void transfor() {

        List<Integer> nums = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6);
        //fiter  eg
        nums.stream().filter(x -> x < 3).forEach(System.out::println);

        //limit eg
        nums.stream().filter(x -> x < 3).limit(2).forEach(System.out::println);

        //skip eg
        nums.stream().filter(x -> x < 3).skip(1).forEach(System.out::println);

        //distinct
        nums.stream().distinct().forEach(System.out::println);

        //map
        nums.stream().map(Math::sqrt).forEach(System.out::println);

        //flatMap


        //sort
        nums.stream().sorted().forEach(System.out::println);

        //sort by userDefin


    }


    public static void stop() {
        List<Integer> nums = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6);
        //allMatch
        System.out.println(nums.stream().allMatch(x -> x >= 1));
        System.out.println(nums.stream().allMatch(x -> x >= 9));

        //anyMatch
        System.out.println(nums.stream().allMatch(x -> x >= 5));

        //noneMatch
        System.out.println(nums.stream().noneMatch(x -> x >= 5));

        //findFirst
        System.out.println(nums.stream().filter(x -> x > 4).findFirst());

        //findAny
        System.out.println(nums.stream().findAny());
        System.out.println(nums.stream().filter(x -> x > 4).findAny());

        //findAny
        System.out.println(nums.stream().count());
        System.out.println(nums.stream().max(Integer::compareTo));
        System.out.println(nums.stream().min(Integer::compareTo));

        //reduce
        //首先将起始值 0 给 x，然后在流中取出一个元素 1 给了 y，然后 x y 相加结果为 1，
        // 再赋给 x，然后再取出一个元素 2 赋给y，然后 x y 相加结果为 3，以此类推
        System.out.println(nums.stream().reduce(0, (x, y) -> x + y));
        System.out.println(nums.stream().reduce(Integer::sum));

        //collect
        nums.stream().collect(Collectors.toList()).stream().forEach(System.out::println);
        nums.stream().collect(Collectors.toSet()).stream().forEach(System.out::println);

        //join
        List<String> list = Arrays.asList("cc", "aa", "dd", "bb");
        System.out.println(list.stream().collect(Collectors.joining()));
        System.out.println(list.stream().collect(Collectors.joining(",")));
        System.out.println(list.stream().collect(Collectors.joining(",")));
        System.out.println(list.stream().collect(Collectors.joining(",", "pre-", "-suf")));


    }

    public static void main(String[] args) {
        createStream();
        transfor();
        stop();
        groupByCase();
    }

    @Test
    public void groupby() {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                        "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);

    }


    /**
     * 通过for循环逻辑，编程上会麻烦点，但是效率上高很多
     */
    private static void groupByCountryAndProvinceNormal(List<Article> articles) {
        Map<String, Map<String, List<Article>>> result = new HashMap<String, Map<String, List<Article>>>();
        for (Article article : articles) {
            Map<String, List<Article>> pMap = result.get(article.getCountryCode());
            if (pMap == null) {
                pMap = new HashMap<String, List<Article>>();
                result.put(article.getCountryCode(), pMap);
            }
            List<Article> list = pMap.get(article.getProvince());
            if (list == null) {
                list = new ArrayList<Article>();
                pMap.put(article.getProvince(), list);
            }
            list.add(article);
        }
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }
    /**
     * 以串行流的方式，通过Collectors做多维度的分组，非常方便，但是性能上很差
     */
    private static void groupByCountryAndProvince(List<Article> articles) {
        Map<String, Map<String, List<Article>>> result = articles.stream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));

        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }

    /**
     * 以并行流的方式，通过Collectors做多维度的分组，性能上比串行流的效率就高很多了
     * 实现方式也很简单，只需要将stream()修改为parallelStream()实现。
     */
    private static void groupByCountryAndProvinceParallel(List<Article> articles) {
        Map<String, Map<String, List<Article>>> result = articles.parallelStream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }


    public static void groupByCase() {
        List<Article> articles = new ArrayList<>();

        Article a1 = new Article("Hello World", "Tom", Arrays.asList("Hello", "World", "Tom"), "CN", "GD");
        Article a2 = new Article("Thank you teacher", "Bruce", Arrays.asList("Thank", "you", "teacher", "Bruce"), "CN",
                "GX");
        Article a3 = new Article("Work is amazing", "Tom", Arrays.asList("Work", "amazing", "Tom"), "CN", "GD");
        Article a4 = new Article("New City", "Lucy", Arrays.asList("New", "City", "Lucy", "Good"), "US", "OT");
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        long start = System.currentTimeMillis();
        groupByCountryAndProvince(articles);
        long end = System.currentTimeMillis();
        System.out.println("串行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvinceParallel(articles);
        end = System.currentTimeMillis();
        System.out.println("并行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvinceNormal(articles);
        end = System.currentTimeMillis();
        System.out.println("普通分组使用时长（毫秒）:" + (end - start));

    }
}
