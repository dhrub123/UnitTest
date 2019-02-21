package com.dhruba;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MatchersTest {

	@Test
	public void testWithMatchers() {
		assertThat("this string", is("this string"));
		assertThat(123, is(123));
	}

	@Test
	public void testWithChainedMatchers() {
		assertThat(123, not(is(345)));
		assertThat(123, anyOf(is(345), is(123)));
		assertThat(123, allOf(not(is(345)), is(123)));
		assertThat("test", anyOf(is("testing"), containsString("est")));
	}
	
	@Test
	public void testWithObjectMatchers() {
		String hello = "hello";
		String nullHello = null;
		assertThat(hello, equalTo("hello"));
		Assertions assertClass = new Assertions();
		assertThat(assertClass, instanceOf(Assertions.class));
		assertThat(hello,notNullValue());
		assertThat(nullHello,nullValue());
		assertThat(123, allOf(not(is(345)), is(123)));
		assertThat(assertClass, sameInstance(assertClass));
	}

}
