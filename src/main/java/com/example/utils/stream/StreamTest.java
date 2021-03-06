package com.example.utils.stream;

import com.example.domain.Pay;
import com.example.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * @Auther: ld
 * @Date: 2019/4/10 14:54
 * @Param ${tags}
 * @Description: 列出班上分数超过85分的学生姓名，并按照分数降序输出用户名字，在java8之前我们需要三个步骤：
 * 1）新建一个List<Student> newList，在for循环中遍历stuList，将分数超过85分的学生装入新的集合中
 * 2）对于新的集合newList进行排序操作
 * 3）遍历打印newList
 */
public class StreamTest {
	private List<Student> stuList = null;

	@Before
	public void init() {
		Random random = new Random();
		stuList = new ArrayList<Student>() {
			{
				for (int i = 0; i < 100; i++) {
					add(new Student("student" + i, random.nextInt(50) + 50));
				}
			}
		};
	}

	@Test
	public void test1() {
		System.out.println(stuList.get(0).getScore());
		List<String> studentList = stuList.stream()
				.filter(x -> x.getScore() > 85)
				.sorted(Comparator.comparing(Student::getScore).reversed())
				.map(Student::getName)
				.collect(toList());
		System.out.println(studentList);
	}

	/**
	 * 通过数组创建流
	 */
	@Test
	public void testArrayStream() {
		//1.通过Arrays.stream
		//1.1基本类型
		int[] arr = new int[]{1, 2, 34, 5};
		IntStream intStream = Arrays.stream(arr);
		//1.2引用类型
		Student[] studentArr = new Student[]{new Student("s1", 29), new Student("s2", 27)};
		Stream<Student> studentStream = Arrays.stream(studentArr);
		//2.通过Stream.of
		Stream<Integer> stream1 = Stream.of(1, 2, 34, 5, 65);
		//注意生成的是int[]的流
		Stream<int[]> stream2 = Stream.of(arr, arr);
		stream2.forEach(System.out::println);
	}

	/**
	 * 通过集合创建流
	 */
	@Test
	public void testCollectionStream() {
		List<String> strs = Arrays.asList("11212", "dfd", "2323", "dfhgf");
		//创建普通流
		Stream<String> stream = strs.stream();
		//创建并行流
		Stream<String> stream1 = strs.parallelStream();
		System.out.println(stream1);
	}

	/**
	 * 产生规律的数据
	 */
	@Test
	public void testUnlimitStream1() {
		Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
		Stream.iterate(0, x -> x).limit(10).forEach(System.out::println);
		//Stream.iterate(0,x->x).limit(10).forEach(System.out::println);与如下代码意思是一样的
		Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);
	}

	/**
	 * map把一种类型的流转换为另外一种类型的流
	 * 将String数组中字母转换为大写
	 */
	@Test
	public void testMap() {
		String[] arr = new String[]{"yes", "YES", "no", "NO"};
		Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
	}

	@Test
	public void testFilter() {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Arrays.stream(arr).filter(x -> x > 3 && x < 8).forEach(System.out::println);
	}

	/**
	 * flapMap：拆解流
	 */
	@Test
	public void testFlapMap1() {
		String[] arr1 = {"a", "b", "c", "d"};
		String[] arr2 = {"e", "f", "c", "d"};
		String[] arr3 = {"h", "j", "c", "d"};
		// Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
		Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
	}

	Student[] students;

	@Before
	public void init1() {
		students = new Student[100];
		for (int i = 0; i < 30; i++) {
			Student student = new Student("user", i);
			students[i] = student;
		}
		for (int i = 30; i < 60; i++) {
			Student student = new Student("user" + i, i);
			students[i] = student;
		}
		for (int i = 60; i < 100; i++) {
			Student student = new Student("user" + i, i);
			students[i] = student;
		}
	}

	@Test
	public void testCollect1() {
		/**
		 * 生成List
		 */
		List<Student> list = Arrays.stream(students).collect(toList());
		list.forEach((x) -> System.out.println(x));
		/**
		 * 生成Set
		 */
		Set<Student> set = Arrays.stream(students).collect(toSet());
		set.forEach((x) -> System.out.println(x));
		/**
		 * 如果包含相同的key，则需要提供第三个参数，否则报错
		 */
		Map<String, Integer> map = Arrays.stream(students).collect(toMap(Student::getName, Student::getScore, (s, a) -> s + a));
		map.forEach((x, y) -> System.out.println(x + "->" + y));
	}

	/***
	 * 封装遍历List
	 */
	@Test
	public void test2() {
		List<User> ls = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setName("user" + i);
			u.setId(i);
			ls.add(u);
		}
		ls.stream().map(x -> {
			User uu = new User();
			uu.setId(x.getId());
			uu.setName(x.getName());
			return uu;
		}).collect(Collectors.toList()).forEach(o -> System.out.println(o.getName()));
	}
}
