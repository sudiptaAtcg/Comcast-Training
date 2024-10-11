package com.sudipta.sprint1;

import com.sudipta.sprint1.exception.InvalidNumberException;

public class A {
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) throws InvalidNumberException {

		if (a == 0 || b == 0) {
			throw new InvalidNumberException("Cannot multiply by zero");
		}
		return a * b;
	}
}
