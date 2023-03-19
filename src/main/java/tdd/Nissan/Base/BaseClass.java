package tdd.Nissan.Base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import tdd.Nissan.Objects.LandingPage;
import tdd.Nissan.Objects.VehiclePage;
import tdd.Nissan.Utils.ReadProperties;
import tdd.Nissan.Objects.CustomizationPage;
import tdd.Nissan.Objects.GetAQuotePage;
import static tdd.Nissan.Utils.IConstant.*;

public class BaseClass extends ExtentListener {

	protected LandingPage landingPage;
	protected VehiclePage vehiclePage;

	protected CustomizationPage customizationPage;
	protected GetAQuotePage getAQuotePage;
	protected WebDriver driver;
	ReadProperties config = new ReadProperties();
	protected Select select;

	@Parameters("browser")
	@BeforeMethod
	public void setUpDriver(String browser) {
		// String browser = config.getProperty(BROWSER);
		String url = config.getProperty(URL);
		long pageLoadWait = config.getNumProperty(PAGELOAD_WAIT);
		long implicitlyWait = config.getNumProperty(IMPLECIT_WAIT);
		initDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClasses(driver);

	}

	private void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		vehiclePage = new VehiclePage(driver);
		getAQuotePage = new GetAQuotePage(driver);
		customizationPage = new CustomizationPage(driver);
	}

	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();

	}

	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver, method.getName()));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}

}
