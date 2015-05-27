package com.syjer;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.function.Function;

import org.junit.Test;

public class Example5 {
	
	private static Function<Integer, Integer> doubleFun = x -> x * 2;
	private static Function<Integer, Optional<Integer>> failure = x -> Optional.<Integer>empty();
	private static Function<Integer, String> toString = x -> Integer.toString(x);
	
	
	// ugly! Don't do that!
	@Test
	public void pyramidOfChecks() {
		Optional<Integer> val = Optional.of(42);
		
		if(val.isPresent()) {
			Optional<Integer> maybeVal = failure.apply(doubleFun.apply(val.get()));
			if(maybeVal.isPresent()) {
				toString.apply(maybeVal.get());
				// notice the pyramid ?
				// is there some kind of pattern that help us to abstract away this uglyness ?
			}
		}
		
	}

	// better!
	@Test
	public void optional() {
		Optional<Integer> val = Optional.of(42);
	
		//
		Optional<String> res = val.map(doubleFun)
		   .flatMap(failure)
		   .map(toString);
		
		assertFalse(res.isPresent());
		
		// notice the failure in the pipeline? :)
	}
}
