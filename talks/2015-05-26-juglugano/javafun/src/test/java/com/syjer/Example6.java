package com.syjer;

import static org.junit.Assert.*;
import java.util.Optional;
import java.util.function.Function;

import org.junit.Test;

public class Example6 {
	
	public interface ThrowableFunction<A,B> {
		B apply(A a) throws Exception;
	}

	
	//our either version is biased to the right component
	public static class Result<R> {
		
		private final Optional<Throwable> left;
		private final Optional<R> right;

		private Result(Optional<Throwable> left, Optional<R> right) {
			this.left = left;
			this.right = right;
		}
		
		public static <R> Result<R> left(Throwable left) {
			return new Result<>(Optional.of(left), Optional.empty());
		}
		
		public static <R> Result<R> right(R right) {
			return new Result<>(Optional.empty(), Optional.of(right));
		}
		
		
		public <R2> Result<R2> flatMap(Function<R, Result<R2>> mapFunction) {
			if(left.isPresent()) {
				return left(left.get());
			} else {
				return mapFunction.apply(right.get());
			}
		}
		
		public boolean hasFailure() {
			return left.isPresent();
		}
	}
	
	
	@Test
	public void testResult() {
		
		Result<Integer> r =  Result.right(42)
				.flatMap(val -> Result.right(val * 2))
				.flatMap(val -> Result.<Integer> left(new Throwable()))
				.flatMap(val -> Result.right(val * 2));
		
		assertTrue(r.hasFailure());
	}
}
