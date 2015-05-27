package com.syjer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class Example4 {

  @Test
  public void reduce() {
	  IntStream stream = IntStream.of(1,2,3,4);
	  
	  assertEquals(10, stream.reduce(0, (a,b) -> a + b));
	  
	  Stream<Integer> stream2 = Arrays.asList(1,2,3,4).stream();
	  
	  stream2.reduce(0, (a, b) -> a + b);
	  
	  //obviously the operations can be more complex :)
	  
	  Stream<Integer> stream3 = Arrays.asList(1,2,3,4).stream();
	  
	  //reduce is a superset of map :D
	  System.err.println(stream3.reduce(new ArrayList<Integer>(), (List<Integer> a, Integer b) -> {a.add(b); return a;}, (a, b) -> {List<Integer> c =  new ArrayList<>(a); c.addAll(b); return c;}));
  }
}
