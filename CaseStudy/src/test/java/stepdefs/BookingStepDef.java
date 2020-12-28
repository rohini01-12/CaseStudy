package stepdefs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import base.PageBase;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.HotelBookingPage;
import pages.PaymentsPage;

public class BookingStepDef extends PageBase{
	HotelBookingPage hotelBookingPage;
	PaymentsPage paymentsPage;
	public BookingStepDef() {
		super();
	}
	@When("^Clicking on the Confirm Booking$")
	public void clicking_on_the_Confirm_Booking() throws Throwable {
		hotelBookingPage= new HotelBookingPage();
		hotelBookingPage.booking();
	}

	@Then("^Alert box displays the message \"([^\"]*)\"$")
	public void alert_box_displays_the_message(String expected) throws Throwable {
		String actual = ConfirmAlert();
		Assert.assertEquals(actual,expected);
		System.out.println("Alert message is " + actual);
	}

	@When("^Enter First Name$")
	public void enter_First_Name() throws Throwable {
		hotelBookingPage.enterDetails("firstName", prop.getProperty("firstName"));
	}

	@When("^Enter Last Name$")
	public void enter_Last_Name() throws Throwable {
		hotelBookingPage.enterDetails("lastName", prop.getProperty("lastName"));
	}

	@When("^Enter valid Email$")
	public void enter_Email() throws Throwable {
		hotelBookingPage.enterDetails("email", prop.getProperty("email"));
	}
	
	@When("^Enter invalid Email$")
	public void enter_invalid_Email() throws Throwable {
		hotelBookingPage.enterDetails("email", "ifghertyi");
	}

	@When("^Enter valid mobile no$")
	public void enter_valid_mobile_no() throws Throwable {
		hotelBookingPage.enterDetails("phone", prop.getProperty("phone"));
	}
		
	@When("^Enter mobile no is (\\d+)$")
	public void enter_mobile_no_is(int arg1) throws Throwable {
		//ConfirmAlert();
		hotelBookingPage.enterDetails("phone", arg1);
	}
	
	@When("^Enter valid city$")
	public void enter_valid_city() throws Throwable {
		hotelBookingPage.enterDetails("city", prop.getProperty("city"));
	}

	@When("^Enter valid state$")
	public void enter_valid_state() throws Throwable {
		hotelBookingPage.enterDetails("state", prop.getProperty("state"));
	
	}

	@When("^Enter Number of guest staying$")
	public void enter_number_of_guest_staying() throws Throwable {
		hotelBookingPage.enterDetails("personCount", prop.getProperty("noOfPerson"));
	
	}
	@When("^Enter valid Card Holder Name$")
	public void enter_valid_Card_Holder_Name() throws Throwable {
	hotelBookingPage.enterDetails("holderName", prop.getProperty("holderName"));
	}

	@When("^Enter valid Debit card Number and CVV$")
	public void enter_valid_Debit_card_Number_and_CVV() throws Throwable {
	hotelBookingPage.enterDetails("debitCard", prop.getProperty("debitCard"));
	hotelBookingPage.enterDetails("cvv", prop.getProperty("cvv"));
	}

	@When("^Enter valid Card expiration month$")
	public void enter_valid_Card_expiration_month() throws Throwable {
	hotelBookingPage.enterDetails("month", prop.getProperty("month"));
	}

	@When("^Enter valid Card expiration year$")
	public void enter_valid_Card_expiration_year() throws Throwable {
	hotelBookingPage.enterDetails("year", prop.getProperty("year"));
	}

	@When("^Enter address$")
	public void enter_address() throws Throwable {
	hotelBookingPage.enterDetails("address", prop.getProperty("address"));
	}
	
	@Then("^Page navigates to success page$")
	public void page_navigates_to_succes_page() throws Throwable {
		Assert.assertEquals("Payment Details", getPageTitle());
		System.out.println("pagelet title is " +getPageTitle());
	}

	@Then("^Page displays message \"([^\"]*)\"$")
	public void page_displays_message(String arg1) throws Throwable {
		String expected = "Booking Completed!";
		paymentsPage = new PaymentsPage();
		Assert.assertEquals(expected,paymentsPage.getheader());
		System.out.println(paymentsPage.getheader());
	}
	
	@After("@ConfirmBooking")
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
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("OS",System.getProperty("OS.name").toString());
		Reporter.setSystemInfo("Environment","Test server");
		}

}
