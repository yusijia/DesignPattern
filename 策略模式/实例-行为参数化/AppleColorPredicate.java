package java8Test;

public class AppleColorPredicate implements Predicate{
	
	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
