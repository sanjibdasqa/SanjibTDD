package tdd.Nissan.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tdd.Nissan.Commom.CommonActions;


public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[text()='Vehicles'])[1]")
	WebElement vehicle;

	public void clickvehicle() throws InterruptedException {
		CommonActions.click(vehicle);
		Thread thread = new Thread();
		thread.sleep(3000);
	}

}
