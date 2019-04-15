package com.example.utils.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: ld
 * @Date: 2019/4/11 14:05
 * @Param ${tags}
 * @Description:
 */
public class StreamExercise {
	/***
	 * 去掉list中空字符串
	 */
	@Test
	public void test() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.stream().forEach(System.out::println);
		//过滤filter
		List<String> ls = filtered.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		ls.stream().forEach(System.out::println);
	}

	/***
	 * forEach
	 */
	@Test
	public void test1() {
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}

	@Test
	public void test2() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// 获取空字符串的数量
		int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
	}

	/***
	 * sorted 方法用于对流进行排序。从小到大
	 */
	@Test
	public void test3() {
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
	}

	/***
	 * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
	 */
	@Test
	public void test4() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("筛选列表: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
	}

	/***
	 * 统计
	 */
	@Test
	public void test5() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
	}

}
