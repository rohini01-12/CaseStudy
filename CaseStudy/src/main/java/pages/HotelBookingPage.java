package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.PageBase;

public class HotelBookingPage extends PageBase {
	@FindBy(id = "txtFirstName")
	WebElement firstName;

	@FindBy(id = "txtLastName")
	WebElement lastName;

	@FindBy(id = "txtEmail")
	WebElement email;

	@FindBy(id = "txtPhone")
	WebElement phone;

	@FindBy(xpath = "//textarea")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "persons")
	WebElement personCount;

	@FindBy(id = "txtCardholderName")
	WebElement holderName;

	@FindBy(id = "txtDebit")
	WebElement debitCard;

	@FindBy(id = "txtCvv")
	WebElement cvv;

	@FindBy(id = "txtMonth")
	WebElement month;

	@FindBy(id = "txtYear")
	WebElement year;

	@FindBy(id = "btnPayment")
	WebElement paymentBtn;

	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	public void booking() {
		paymentBtn.click();
	}

	public void enterDetails(String option, Object detail) {
		if (option.equals("firstName"))
			firstName.sendKeys(detail.toString());
		else if (option.equals("lastName"))
			lastName.sendKeys(detail.toString());
		else if (option.equals("email")) {
			email.clear();
			email.sendKeys(detail.toString());
		}
		else if (option.equals("phone")) {
			phone.clear();
			phone.sendKeys(detail.toString());
		} else if (option.equals("address"))
			address.sendKeys(detail.toString());
		else if (option.equals("city"))
			selectDropdown(city, detail);
		else if (option.equals("state"))
			selectDropdown(state, detail);
		else if (option.equals("personCount"))
		    selectDropdown(personCount,detail);
		else if (option.equals("holderName"))
			holderName.sendKeys(detail.toString());
		else if (option.equals("debitCard"))
			debitCard.sendKeys(detail.toString());
		else if (option.equals("cvv"))
			cvv.sendKeys(detail.toString());
		else if (option.equals("month"))
			month.sendKeys(detail.toString());
		else if (option.equals("year"))
			year.sendKeys(detail.toString());

	}



}
