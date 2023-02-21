package tdd.Nissan.Objects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tdd.Nissan.Commom.CommonActions;

public class GetAQuotePage {
	
	
	public GetAQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//span[text()='Get Internet Quote']
	@FindBy(xpath = "//span[text()='Get Internet Quote']")
   //@FindBy(xpath = "//span[starts-with(text(),'Get In')]")
	WebElement internetquote;
	
	@FindBy(xpath="//h3//parent::a[@data-multiplebrochure-url='/content/nissan_prod/en_US/index/shopping-tools/request-internet-quote/jcr:content/freeEditorial/contentzone_2475/columns/columns12_1dfc/col1-par/vehiclelisting_ab95.none.json/content/nissan_prod/en_US/cars/2023-versa.car']")
	WebElement Sentra;
	
	
	@FindBy(xpath = "//span[@class='headline']")
	WebElement gettitle ;
	
	
	@FindBy(xpath = "(//input[@id='textfield_2dac'])[1]")
	WebElement firstname;
	
	
	@FindBy(xpath = "(//input[@id='textfield_ea81']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='textField2']")
	WebElement phoneno;
	
	
	public void internetquote(WebDriver driver) throws InterruptedException {
							
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Thread.sleep(2000);
	  //js.executeScript("window.scrollBy(0, 3000)", "");
	    js.executeScript("arguments[0].scrollIntoView();", internetquote);
		CommonActions.click(internetquote);
		Thread.sleep(20);
		
	}

	public void sentraselect(WebDriver driver)  {
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(2500);
		js.executeScript("arguments[0].click()", Sentra);
//		js.executeScript("arguments[0].scrollIntoView();", Sentra);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//		wait.until(ExpectedConditions.elementToBeClickable(Sentra)).click();
//		CommonActions.click(Sentra);
	}
	
	public void validatetitleintenet(String expectedtitle) {
	CommonActions.validate(gettitle, expectedtitle);}
	
	public void firstname( String name) {
		CommonActions.insert(firstname, name);
	}
	
	public void lastname( String name) {
		CommonActions.insert(lastname, name);
	}
	
	public void inputphonecode(String phone) {
		CommonActions.insert(phoneno, phone);
	}
	
	
}
