package tdd.Nissan.InternetQuote.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import tdd.Nissan.Base.BaseClass;
import tdd.Nissan.Reportings.Logs;

public class InternetQuoteTest extends BaseClass {
	
	@Test(enabled = true, groups = "internet")
	public void internetquote1() throws InterruptedException {
	
	getAQuotePage.internetquote(driver);
	getAQuotePage.sentraselect(driver);
	getAQuotePage.validatetitleintenet("REQUEST A QUOTE");
	Thread.sleep(5000);
	getAQuotePage.firstname("Sanjib");
	//getAQuotePage.lastname("Das");
	getAQuotePage.inputphonecode("02587502");
	
	
	}
	
	@Test(enabled = false, priority = 0, groups = {"internet", "non-func"}, dependsOnMethods = "test2", ignoreMissingDependencies = true)
	
	public void test1 () {
		Logs.log("Test1");
	}	
	@Test(enabled = false, priority = 1, groups = {"internet", "non-func"},invocationCount = 2)
	
	public void test2 () {
		Logs.log("Test2");
	}
		
@Test(enabled = false , priority = 1, groups = {"internet", "non-func"})
	
	public void test3 () {
		Logs.log("Test3");
		Assert.fail();
	}

@Test(enabled = false, priority = 1, groups = {"internet", "non-func"}, retryAnalyzer =  tdd.Nissan.Retry.RetryFailedTests.class)

public void testRetry () {
	Logs.log("Retry Test");
	Assert.fail();
}
			
	}
	



