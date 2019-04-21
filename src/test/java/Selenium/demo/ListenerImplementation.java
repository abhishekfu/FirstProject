package Selenium.demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersClass.class)
public class ListenerImplementation {
	@Test
	public void test1() {
		System.out.println("In method test1");
	}
	@Test
	public void test2() {
		System.out.println("In method test2");
		Assert.assertEquals(10, 11);
	}
}
