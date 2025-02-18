package com.valtecht.raining.simple;

import com.valtech.training.simple.Operation;

import junit.framework.TestCase;

public class OperationTest extends TestCase {

//	Operation add = (a,b)-> a+b;
//	Operation sub = (a,b)-> a-b;
//	Operation mul = (a,b)-> a*b;
//	Operation div = (a,b)-> a/b;

	public void testAdd() {
		assertEquals(2,Operation.ADD.perform(1,1));
		assertEquals(0,Operation.SUB.perform(1,1));
		assertEquals(1,Operation.MUL.perform(1,1));
		assertEquals(1,Operation.DIV.perform(1,1));

	}
}
