package realtimeintquestpart2;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependency {

	@Test(description="Login test case",groups = {"sanity"})
	public void login(){
	   Assert.assertTrue(true);	
	}
	
	@Test(description="Ticket booking",dependsOnMethods="login",groups = {"sanity"})
	public void tBooking(){
		Assert.assertTrue(false);
	}
	
	@Test(description="Ticket payments",dependsOnGroups="sanity")
	public void payment(){
		Assert.assertTrue(true);
	}

}
