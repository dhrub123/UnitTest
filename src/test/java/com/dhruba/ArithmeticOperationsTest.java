package com.dhruba;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticOperationsTest {

	@Test
	public void testDivide() {
		ArithmeticOperations aops = new ArithmeticOperations();
		assertEquals("10 divided by 5 must be 2", 2, aops.divide(10, 5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrown() {
		ArithmeticOperations aops = new ArithmeticOperations();
		aops.divide(1000, 5);
	}

}
