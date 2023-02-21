package tdd.Nissan.VehiclePage.Test;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import tdd.Nissan.Base.BaseClass;

public class VehiclePageTest extends BaseClass {
	
	
	@Test (priority = 2, groups = "vehicle")
	public void vehicleRougeSportTest() throws InterruptedException {
		landingPage.clickvehicle();
		System.out.println("The Title of the Page is: " + driver.getTitle());
		vehiclePage.clickRougSport(driver);
		vehiclePage.buildAndPriceTest(driver);
		vehiclePage.buildtest1(driver);
		//vehiclePage.closebutton();
        vehiclePage.buildtest2(driver);
		Thread.sleep(1500);

	}
	
			
		}
		
		
		
		

	


//a.Buttonstyles__StyledButton-sc-1s5ly6x-1.ksdsrj.RecentBuildBannerstyles__Button-sc-s05vxu-15.hmlRxu

