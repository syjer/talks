package com.syjer;

import static org.junit.Assert.*;
import static java.lang.Integer.*;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class Example2 {

  @Test
  public void curryExample() {
	// uncurried form, multiple parameters
	BiFunction<Integer, Integer, Integer> sumUncurried = (a, b) -> a + b;
		
	assertEquals(valueOf(42), sumUncurried.apply(21, 21));
		
		
	// curried form
	Function<Integer, Function<Integer, Integer>> sumCurried = a -> b -> a + b;
	
	assertEquals(valueOf(42), sumCurried.apply(21).apply(21));
	
	// apply partially
	Function<Integer, Integer> partiallyApplied = sumCurried.apply(21);
	
	assertEquals(valueOf(42), partiallyApplied.apply(21));
	assertEquals(valueOf(21), partiallyApplied.apply(0));
  }
	
  //generic curry function, for transforming a BiFunction to it's currified form
  public static <T, U, R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> f) {
    return a -> b -> f.apply(a, b);
  }
  
  public static <T, U, R> BiFunction<T, U, R> uncurry(Function<T, Function<U, R>> f) {
	  return (a, b) -> f.apply(a).apply(b);
  }
  
  @Test
  public void curryExample2() {
	// uncurried form, multiple parameters
	BiFunction<Integer, Integer, Integer> sumUncurried = (a, b) -> a + b;
	
	Function<Integer, Function<Integer, Integer>> curried = curry(sumUncurried);
	
	BiFunction<Integer, Integer, Integer> uncurried = uncurry(curried);
	
	assertEquals(valueOf(42), curried.apply(21).apply(21));
	assertEquals(valueOf(42), uncurried.apply(21, 21));
  }
	
}
