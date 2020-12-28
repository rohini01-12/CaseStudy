package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;

public class LoginPage extends PageBase {
	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "userPwd")
	WebElement password;

	@FindBy(xpath = "//h1[contains(text(),'Hotel Booking Application')]")
	WebElement header;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(id = "userErrMsg")
	WebElement userNameNotify;

	@FindBy(id = "pwdErrMsg")
	WebElement passWordNotify;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getheader() {
		String headerTitle = header.getText();
		return headerTitle;
	}

	public void enterCredentials(String uname, String pword) {
			userName.sendKeys(uname);
			password.sendKeys(pword);
	}

	public String getAlertMessage(String option) {
		String message = "";
		if (option.equals("valid")) {
			message = driver.getTitle();
			System.out.println("Login is succesful and navigated to Hotel Booking page");
		} else if (option.equals("NoUsername")) {
			message = userNameNotify.getText();
			System.out.println("Login is not succesful");
		} else if (option.equals("NoPassword")) {
			message = passWordNotify.getText();
			System.out.println("Login is not succesful");
		}
		return message;

	}

	public void login() {
		loginBtn.click();
		
	}

}