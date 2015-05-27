package com.syjer;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;

public class Example3 {

  @Test
  public void map() {
    Optional<Integer> v = Optional.of(42);
		
	//same function name
	v.map(a -> a * 2);
		
	IntStream stream = IntStream.of(0,1,2,3,4);
		
	//same function name
	stream.map(i -> i * 2);
  }
}
