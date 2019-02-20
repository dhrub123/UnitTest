package com.dhruba;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationsTest {

	@Test
	public void testConcatenate() {
		StringOperations sops = new StringOperations();
		assertEquals("Hello and Dhruba concatenated to HelloDhruba", "HelloDhruba",
				sops.concatenate("Hello", "Dhruba"));
	}

}
