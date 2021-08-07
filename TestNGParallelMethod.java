package realtimeintquestpart2;

import org.testng.annotations.Test;

public class TestNGParallelMethod {

	@Test(description="Login test case")
	public void login() throws InterruptedException{
	  Thread.sleep(10 * 000);
	  System.out.println("Thread ID = " + Thread.currentThread().getId());
	  
	}
	
	@Test(description="Welcome Page validation")
	public void welcomePage() throws InterruptedException{
		Thread.sleep(10 * 000);
		System.out.println("Thread ID = " + Thread.currentThread().getId());
	}

}
