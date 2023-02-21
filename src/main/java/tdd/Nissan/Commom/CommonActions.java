package tdd.Nissan.Commom;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import tdd.Nissan.Reportings.Logs;

public class CommonActions {

	public static void click(WebElement element) {
		try {
			element.click();
			Logs.log(element + " ---> has been clicked");

		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");

			Assert.fail();
		}

	}

	public static void validate(WebElement element, String expected) {
		String actual = "";
		try {
			actual = element.getText();
			Logs.log("Validating ---> Actual : *** " + actual + " ***. Expected : *** " + expected + " ***");

		} catch (NullPointerException | NoSuchElementException e) {

			Logs.log(element + " ---> Element Not Found");

			Assert.fail();
		}
		Assert.assertEquals(actual, expected);

	}

	public static void insert(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(value + " <--- This value has been passed into ---> " + element);

		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");

			Assert.fail();

		}

	}
}
