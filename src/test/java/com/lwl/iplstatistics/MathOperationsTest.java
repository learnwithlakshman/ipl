package com.lwl.iplstatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathOperationsTest {

	@Test
	void biggestWithFirstNumberAsBig() {
		MathOperations obj = new MathOperations();
		assertEquals(15, obj.biggest(15, 10, 12));
	}
	@Test
	void biggestWithSecondNumberAsBig() {
		MathOperations obj = new MathOperations();
		assertEquals(15, obj.biggest(10, 15, 12));
	}
	@Test
	void biggestWithThirdNumberAsBig() {
		MathOperations obj = new MathOperations();
		assertEquals(20, obj.biggest(10, 15, 20));
	}
	
	@Test
	void biggestWithNegativeNumbers() {
		MathOperations obj = new MathOperations();
		assertEquals(-10, obj.biggest(-10, -15, -12));
	}
	@Test
	void biggestWithSameValue() {
		MathOperations obj = new MathOperations();
		assertEquals(10, obj.biggest(10, 10, 10));
	}
}
