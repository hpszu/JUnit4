package cn.edu.szu.junit4.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.edu.szu.junit4.User;

public class UserTest {

	@Test
	public void testGetName() {
		String name=new User().getName();
		assertEquals("Name", name);
	}

}
