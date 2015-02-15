package cn.edu.szu.junit4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.edu.szu.junit4.T;

public class TTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@Before
	public void before() {
		System.out.println("before");
	}

	@Test
	public void testAdd() {
		int z = new T().add(2, 4);
		assertEquals(6, z);
		assertTrue(z > 3);
		assertTrue("12", z > 10);
		// assertThat(z, is(8));
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}
}
