package sample;

import org.testng.annotations.Test;

public class DemoReport {
	@Test(timeOut=1000)
	public void firstTestCase() throws InterruptedException
	{
		System.out.println("First test case to be failed");
		Thread.sleep(1500);
	}
	@Test
	public void secondTestCase()
	{
		System.out.println("Second test case");
	}
}
