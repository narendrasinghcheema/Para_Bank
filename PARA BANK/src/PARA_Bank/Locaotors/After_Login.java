package PARA_Bank.Locaotors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class After_Login {

	@FindBy(xpath = "//b[@class='ng-binding']")
	static WebElement total_Price;
	
	@FindBy(xpath = "//tr[contains(@ng-repeat, 'account')]//a")
	WebElement first_account_text;
	
	static String Ac = "";
	static String Ab = "";
	static WebDriver driver;
	
	public After_Login(WebDriver IDriver2)
	{
		this.driver = IDriver2;
	}
	
	public static void Verify_Initial_Money()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(total_Price.isDisplayed())
		{
			System.out.println("total price is = "+total_Price.getText());
		}
		String abniklivalue = total_Price.getText();
		
	    Ac = abniklivalue;
    }
	
	public void SetFirstAccount()
	{
		String firstAcc = first_account_text.getText();
		System.out.println("First Account number is = "+firstAcc);
		this.Ab = firstAcc;
	}
	
	
	
	public static String GFirst_Account()
	{
		return Ab;
	}
	
	public static String printKrovaluejophle_bnaithis()
	{
		return Ac; 
	}
}
