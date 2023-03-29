package PARA_Bank.Locaotors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PARABank_Login {
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement user_Name;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement user_Password;
	
	@FindBy(xpath = "//input[@class='button']")
	WebElement Login_Button;
	
	@FindBy(xpath = "//*[contains(@class,'error')]")
	WebElement Error;
	
	
	WebDriver driver;
	
	public PARABank_Login(WebDriver IDriver)
	{
		this.driver = IDriver;
	}
	
	public void Login(String user_N, String User_P)
	{
		
		user_Name.sendKeys(user_N);
		user_Password.sendKeys(User_P);
		Login_Button.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void Error_verify()
	{
		switch(Error.getText())
		{
		case "An internal error has occurred and has been logged.":
			System.out.println("An internal error has occurred and has been logged");
			break;
		
		case "Please enter a username and password.":
			System.out.println("Please enter a username and password");
			break;
			
		}
		
	}
	
	public void VerifyValiddata()
	{
		String url = driver.getCurrentUrl();
		if(url.equals("https://parabank.parasoft.com/parabank/overview.htm"))
		{
			System.out.println("user is successfully login");
			Assert.assertTrue(true);
		}
		
	}
	
	
}
