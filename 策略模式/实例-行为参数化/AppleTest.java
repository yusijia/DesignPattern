package java8Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTest {

	/**
	 * 
	 * @param inventory 苹果集合
	 * @param p 行为参数
	 * @return 返回过滤后的一个集合
	 */
	public static List<Apple> filter(List<Apple> inventory, Predicate p){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory){
			if (p.test(apple)) {	// 这里可以通过替换ApplePredicate使用不同的行为过滤苹果
				result.add(apple);
			}
		}
		return result;
	}       
	
	public static void main(String[] args) {
		/*
		 * 行为参数化的第一种方法：通过设计，建模，将过滤苹果集合的条件抽象出来用谓词表示
		 * ApplePredicate::test(Apple a)。再通过相应的ApplePredicate的实现类替换掉不同的过滤条件语句
		 * 
		 * 谓词：在数学上常常用来代表一个类似函数的东西，它接受一个参数值，并返回true或false。
		 */
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), 
											new Apple(155, "green"), 
											new Apple(120, "red"));	
		
		/*List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);
		
		List<Apple> greenApples = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples);*/
		
		// 第二种方法是用匿名内部类的方式实现不同的过滤行为
		/*List<Apple> redApples = filter(inventory, new ApplePredicate(){

			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
			
		});
		System.out.println(redApples);*/
		
		// 第三种方式是使用lambda表达式
		/*List<Apple> redApples2 = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		System.out.println(redApples2);*/

	}
	
}
