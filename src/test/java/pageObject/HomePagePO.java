package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePagePO {
	
	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement clickSearch;
	
	@FindBy(xpath="//h2")
    private List<WebElement> booksList;
	
	
	public HomePagePO(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchBook() throws InterruptedException{
		
		boolean flag = false;
		
		search.sendKeys("Books");
		clickSearch.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(booksList));

		System.out.println("Here is the book list");
		for(WebElement a:booksList) {
			System.out.println("Books List: " + a.getText());
			Reporter.log("Books List: " + a.getText());
		}
		return flag;
	}

}
