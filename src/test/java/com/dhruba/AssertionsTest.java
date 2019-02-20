package com.dhruba;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionsTest {

	@Test
	public void testGetFalseFlag() {
		Assertions assertClass = new Assertions();
		assertFalse(assertClass.getFalseFlag());
	}

	@Test
	public void testGetTrueFlag() {
		Assertions assertClass = new Assertions();
		assertTrue(assertClass.getTrueFlag());
	}

	@Test
	public void testGetArray() {
		Assertions assertClass = new Assertions();
		String[] expectedArray = { "one", "two", "three" };
		assertArrayEquals(expectedArray, assertClass.getArray());
	}

	@Test
	public void testSameObject() {
		Assertions assertClass = new Assertions();
		assertSame(assertClass, assertClass);
	}

	@Test
	public void testDifferentObject() {
		Assertions assertClass = new Assertions();
		Assertions differentAssertClass = new Assertions();
		assertNotSame(assertClass, differentAssertClass);
	}

	@Test
	public void testNotNull() {
		Assertions assertClass = new Assertions();
		assertNotNull(assertClass);
	}

	@Test
	public void testNull() {
		Assertions assertClass = null;
		assertNull(assertClass);
	}

}
