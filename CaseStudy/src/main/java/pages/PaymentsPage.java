package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;

public class PaymentsPage extends PageBase{
	
	@FindBy(xpath = "//h1[text()='Booking Completed!']")
	WebElement header;
	
	public PaymentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getheader() {
		String headerTitle = header.getText();
		return headerTitle;
	}

}
