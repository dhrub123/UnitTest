package com.dhruba;

public class ArithmeticOperations {

	public int divide(int x, int y) {
		if (x > 999) {
			throw new IllegalArgumentException("Please enter a number less than 100");
		}
		return x / y;
	}

}
