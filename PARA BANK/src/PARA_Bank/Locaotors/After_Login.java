package PARA_Bank.Locaotors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class After_Login {

	@FindBy(xpath = "//b[@class='ng-binding']")
	WebElement total_Price;
	WebDriver driver;
	
	public After_Login(WebDriver IDriver2)
	{
		this.driver = IDriver2;
	}
	
	public void Verify_Initial_Money()
	{
		String price = total_Price.getText();
		if(total_Price.isDisplayed())
		{
			System.out.println("total price is = "+price);
		}
		
	}
}
