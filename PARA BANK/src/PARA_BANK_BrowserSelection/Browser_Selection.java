package PARA_BANK_BrowserSelection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser_Selection {

	public static WebDriver driver;
	public static WebDriver Select(String Browser_Name, String url)
	{
		if(Browser_Name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(Browser_Name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
