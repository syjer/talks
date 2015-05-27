package com.syjer;

import static org.junit.Assert.*;
import static java.lang.Integer.*;
import static java.util.function.Function.*;

import java.util.function.Function;

import org.junit.Test;

public class Example1 {
	
  @Test
  public void higherOrder() {
    //stored as a variable
	Function<Integer, Integer> doubler = v -> v * 2;
	
	assertEquals(valueOf(42), doubler.apply(21));
		
	// can receive function as a parameter
	Function<Function<Integer, Integer>, Integer> sum42 = f -> f.apply(42) + f.apply(42);
	
	assertEquals(valueOf(84), sum42.apply(identity()));
	assertEquals(valueOf(42 * 4), sum42.apply(doubler));
		
	
	// can return function (and take a function as a parameter)
	// and here we can see the lack of type inference :(
	Function<Function<Integer, Integer>, Function<Integer, Integer>> apply2 = f -> f.andThen(f);
	
	//
	assertEquals(valueOf(42), apply2.apply(identity()).apply(42));
	
	//we apply doubler 2 times over the number 21
	assertEquals(valueOf(84), apply2.apply(doubler).apply(21));
  }
}
