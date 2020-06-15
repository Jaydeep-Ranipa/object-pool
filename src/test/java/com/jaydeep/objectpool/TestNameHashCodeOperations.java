package com.jaydeep.objectpool;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestNameHashCodeOperations {
	@Test
	public void testNameHashCode() throws Exception {
		Name name1 = Name.newName("Jaydeep", "Ranipa");
		Name name2 = Name.newName("Jaydeep", "Ranipa");
		assertTrue(name1 == name2);
	}
}
