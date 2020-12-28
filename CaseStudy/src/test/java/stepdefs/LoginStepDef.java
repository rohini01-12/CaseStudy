package stepdefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import base.PageBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginStepDef extends PageBase {
	LoginPage loginPage;
	String pagetitle;

	@Given("^Login HTML page is opened$")
	public void login_HTML_page_is_opened() throws Throwable {
		initialize();
	}

	@Then("^Login page heading as Hotel Booking Application$")
	public void login_page_heading_as_Hotel_Booking_Application() throws Throwable {
		loginPage = new LoginPage();
		String expected = "Hotel Booking Application";
		Assert.assertEquals(expected,loginPage.getheader());
		System.out.println(expected);
	}

	@When("^Username is not entered$")
	public void username_is_not_entered() throws Throwable {
		loginPage.enterCredentials("", "");
	}

	@When("^Clicking on the Login button$")
	public void clicking_on_the_Login_button() throws Throwable {
		loginPage.login();
	}

	@Then("^Please enter UserName error message is displayed$")
	public void please_enter_UserName_error_message_is_displayed() throws Throwable {
		String expected = "* Please enter userName.";
		Assert.assertEquals(expected, loginPage.getAlertMessage("NoUsername"));
		System.out.println(expected);
	}

	@When("^Password is not entered$")
	public void password_is_not_entered() throws Throwable {
		loginPage.enterCredentials("admin", "");
	}

	@Then("^Please enter Password error message is displayed$")
	public void please_enter_Password_error_message_is_displayed() throws Throwable {
		String expected = "* Please enter password.";
		Assert.assertEquals(expected, loginPage.getAlertMessage("NoPassword"));
		System.out.println(expected);
	}

	@When("^User enters credentials as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_credentials_as_and(String arg1, String arg2) throws Throwable {
		loginPage.enterCredentials(arg1, arg2);
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		pagetitle = getPageTitle();
	}

	@Then("^Next page loaded as Hotel Booking$")
	public void next_page_loaded_as_Hotel_Booking() throws Throwable {
		Assert.assertEquals("Hotel Booking", pagetitle);
		System.out.println(pagetitle);
	}

	@After("@InvalidLogin , @ValidLogin")
	public void tearDown_Screenshot(Scenario scenario) throws IOException {

		Reporter.addScenarioLog("Incase of failure, Take screenshot");
		if(scenario.isFailed())
		{
			String screenshotname = scenario.getName().replace(" ", "_");
			TakesScreenshot screen = (TakesScreenshot) driver;
			File srcpath = screen.getScreenshotAs(OutputType.FILE);
			File destpath = new File(System.getProperty("user.dir")+"//target//html//" +screenshotname+".png");
			FileUtils.copyFile(srcpath, destpath);
			Reporter.addScreenCaptureFromPath(destpath.toString());
		}
		driver.close();
		}
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("OS",System.getProperty("OS.name").toString());
		Reporter.setSystemInfo("Environment","Test server");
		}
}
