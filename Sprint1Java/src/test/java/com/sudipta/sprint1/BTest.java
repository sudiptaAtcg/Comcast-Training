package com.sudipta.sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sudipta.sprint1.exception.InvalidNumberException;
import com.sudipta.sprint1.exception.InvalidStringException;

class BTest {

	private B obj;
	private InvalidNumberException message;
	private InvalidStringException message1;

	@BeforeEach
	public void setUp() {
		obj = new B();

	}

	@Test
	void testIsPrimeWithNegativeNumber() throws InvalidNumberException {
		message = assertThrows(InvalidNumberException.class, () -> {
			obj.isPrime(-1);
		});
		assertEquals("Number should be greater than 1", message.getMessage());
	}

	@Test
	void testIsPrimeWithZero() throws InvalidNumberException {
		message = assertThrows(InvalidNumberException.class, () -> {
			obj.isPrime(0);
		});
		assertEquals("Number should be greater than 1", message.getMessage());
	}

	@Test
	void testIsPrimeWithOne() throws InvalidNumberException {
		message = assertThrows(InvalidNumberException.class, () -> {
			obj.isPrime(1);
		});
		assertEquals("Number should be greater than 1", message.getMessage());
	}

	@Test
	void testIsPrime() throws InvalidNumberException {
		assertTrue(obj.isPrime(2));
		assertTrue(obj.isPrime(5));
		assertFalse(obj.isPrime(4));
		assertThat(obj.isPrime(13)).isEqualTo(true);
		assertThat(obj.isPrime(9)).isEqualTo(false);
	}

	@Test
	void testIsPalindrome() throws InvalidStringException {
		assertTrue(obj.isPalindrome("Madam"));
		assertFalse(obj.isPalindrome("Hello"));
		assertThat(obj.isPalindrome("121")).isEqualTo(true);
		assertThat(obj.isPalindrome("Mohit")).isEqualTo(false);

	}

	@Test
	void testIsPalindromeWithException() throws InvalidStringException {
		message1 = assertThrows(InvalidStringException.class, () -> {
			obj.isPalindrome("");
		});
		assertEquals("String should not be null or empty", message1.getMessage());

	}

}
