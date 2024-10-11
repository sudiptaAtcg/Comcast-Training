package com.sudipta.sprint1;

import java.util.stream.IntStream;

import com.sudipta.sprint1.exception.InvalidNumberException;
import com.sudipta.sprint1.exception.InvalidStringException;

public class B {

	public boolean isPrime(int number) throws InvalidNumberException {
		if (number <= 1)
			throw new InvalidNumberException("Number should be greater than 1");

		return IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(i -> number % i == 0);

	}

	public boolean isPalindrome(String str) throws InvalidStringException {

		if (str == null || str.isEmpty())
			throw new InvalidStringException("String should not be null or empty");

		return IntStream.rangeClosed(0, str.length() / 2).allMatch(
				i -> Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(str.length() - 1 - i)));
	}
}
