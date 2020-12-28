package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	public static String url;
	public static Properties prop;
	String path = System.getProperty("user.dir") + "//src//main//resources//config//config.properties";
	protected static WebDriver driver;
	FileInputStream fin;

	public PageBase() {
		prop = new Properties();
		try {
			fin = new FileInputStream(path);
			prop.load(fin);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initialize() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("browser is" + browser);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		url = System.getProperty("user.dir") + prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();

		System.out.println("application is launched");
	}

	public String ConfirmAlert() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		return message;
	}

	public void selectDropdown(WebElement elementName, Object detail) {
		Select select = new Select(elementName);
		select.selectByVisibleText(detail.toString());
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}
