package tdd.Nissan.Practice;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import tdd.Nissan.Base.BaseClass;

public class LinearScriptingTest extends BaseClass{
	
	
	@Test(enabled = false)
	public void use_of_getTitle_method_in_home_page() {
		System.out.println("The Title of the Page is: " + driver.getTitle());
	
	}
	
	@Test(enabled = true)
	public void clickVehicleTest() {
	//	landingPage.clickvehicle();
	}
	
	
	
	

}
