package tdd.Nissan.InternetQuote.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tdd.Nissan.Base.BaseClass;
import tdd.Nissan.Utils.AutoData;

public class ParameterisedTestInternet extends BaseClass {

	@Parameters({ "expectedtitle1", "firstname1", "phonecode" })
	@Test(enabled = false, groups = "internet")
	public void internetquote1(String expectedtitle, String firstname, String phonecode) throws InterruptedException {

		getAQuotePage.internetquote(driver);
		getAQuotePage.sentraselect(driver);
		getAQuotePage.validatetitleintenet(expectedtitle);
		Thread.sleep(5000);
		getAQuotePage.firstname(firstname);
		// getAQuotePage.lastname("Das");
		getAQuotePage.inputphonecode(phonecode);

	}

	@Parameters({ "expectedtitle1", "firstname1", "phonecode" })
	@Test(enabled = true, groups = "internet")
	public void internetquote1_auto_data(String expectedtitle, String firstname, String phonecode)
		throws InterruptedException {
		AutoData autoData = new AutoData(expectedtitle, firstname, phonecode);
		getAQuotePage.internetquote(driver);
		getAQuotePage.sentraselect(driver);
		getAQuotePage.validatetitleintenet(autoData.getGettitle());
		Thread.sleep(5000);
		getAQuotePage.firstname(firstname);
		// getAQuotePage.lastname("Das");
		getAQuotePage.inputphonecode(phonecode);

	}

}
