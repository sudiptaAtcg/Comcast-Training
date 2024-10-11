package com.sudipta.sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sudipta.sprint1.exception.InvalidNumberException;

public class ATest {

	private A obj;

	@BeforeEach
	public void setUp() {
		obj = new A();
	}

	@Test
	public void testAdd() {
		assertEquals(5, obj.add(2, 3));
		assertNotEquals(4, obj.add(2, 5));
		assertThat(obj.add(3, 2)).isEqualTo(5);
		assertThat(obj.add(3, 6)).isNotEqualTo(4);
	}

	@Test
	public void testSubtract() {
		assertEquals(1, obj.subtract(4, 3));
		assertNotEquals(4, obj.subtract(8, 5));
		assertThat(obj.subtract(3, 2)).isEqualTo(1);
		assertThat(obj.subtract(8, 6)).isNotEqualTo(4);
	}

	@Test
	public void testMultiply() throws InvalidNumberException {
		assertEquals(6, obj.multiply(2, 3));
		assertNotEquals(43, obj.multiply(8, 5));
		assertThat(obj.multiply(-3, 2)).isEqualTo(-6);
		assertThat(obj.multiply(8, 6)).isNotEqualTo(10);
	}

	@Test
	public void testMultiplyWithZero() throws InvalidNumberException {
		InvalidNumberException m1 = assertThrows(InvalidNumberException.class, () -> {
			obj.multiply(0, 5);
		});
		assertEquals("Cannot multiply by zero", m1.getMessage());

		InvalidNumberException m2 = assertThrows(InvalidNumberException.class, () -> {
			obj.multiply(5, 0);
		});
		assertEquals("Cannot multiply by zero", m2.getMessage());
	}

}
