package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObject.HomePagePO;
import wrapperClass.TestProperty;
import wrapperClass.WebBase;

public class HomePageTest extends WebBase{
	
	@Test
		public void tc() throws InterruptedException {
		String url = TestProperty.readTestProperites("URL");
		driver.get(url);
		HomePagePO home =new HomePagePO(driver);
		boolean flag =  home.searchBook();
		
		if(flag)
			Reporter.log("Book List Printed as Expected - TC Passed");
		else {
			Reporter.log("Book List Printed as Expected - TC Failed");
			Assert.fail();
		}
			
	}
	
	

}
