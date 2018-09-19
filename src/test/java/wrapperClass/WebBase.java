package wrapperClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebBase {

	public WebDriver driver;

	@BeforeClass
	public void browser() {
		String browser = TestProperty.readTestProperites("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestProperty.readTestProperites("winchromedriverLocation"));
			driver = new ChromeDriver();
		} else if (browser.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", TestProperty.readTestProperites("ffriverLocation"));
			driver = new FirefoxDriver();
		} else
			System.out.println("No browser to run the test");
	}

	@AfterClass
	public void browserclose() {
		driver.close();
	}

}
