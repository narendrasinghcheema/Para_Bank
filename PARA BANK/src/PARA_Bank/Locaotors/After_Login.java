package PARA_Bank.Locaotors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class After_Login {

	@FindBy(xpath = "//b[@class='ng-binding']")
	WebElement total_Price;
	
	@FindBy(xpath = "//tr[contains(@ng-repeat, 'account')]//a")
	WebElement first_account_text;
	
	String Ac = "";
	String Ab = "";
	WebDriver driver;
	
	public After_Login(WebDriver IDriver2)
	{
		this.driver = IDriver2;
	}
	
	public void Verify_Initial_Money()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(total_Price.isDisplayed())
		{
			System.out.println("total price is = "+total_Price.getText());
		}
		String abniklivalue = total_Price.getText();
		
	    this.Ac = abniklivalue;
	    String firstAccount_Text = first_account_text.getText();
	    System.out.println("phle account ka number = "+firstAccount_Text);
	    this.Ab = firstAccount_Text;
	    System.out.println("phle account ka number ab ki = "+Ab);
	
	
    }
	
	
	
	public String returnFirst_Account()
	{
		return Ab;
	}
	
	public String printKrovaluejophle_bnaithis()
	{
		return Ac; 
	}
}
