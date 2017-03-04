package java8Test;

public class AppleWeightPredicate implements Predicate{

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150; 
	}

}
