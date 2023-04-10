package PARA_Bank.Locaotors;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert.*;

public class Transfer_Funds {

	
	After_Login a;
	
	@FindBy(xpath = "//a[text()='Transfer Funds']")
	WebElement TransferFunds_Buttone;
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement interAmount;
	
	@FindBy(xpath = "//select[@id='toAccountId']")
	WebElement select_Reciver_Account;
	
	@FindBy(xpath = "//input[@class='button']")
	WebElement transfer_Buttone;
	
	@FindBy(xpath = "//*[@id='amount.errors']")
	WebElement error;
	
	static String number_amount = "";
	String accountNumber_Select = "";
	
	WebDriver driver;
	
	public Transfer_Funds(WebDriver IDriver88)
	{
		this.driver = IDriver88;
	}
	
	public void click_on_tranfer_buttone()
	{
		TransferFunds_Buttone.click();
	}
	
	public void interAmountfor_Transfer(String GiveAmmount, String select_Account)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		interAmount.sendKeys(GiveAmmount);
		
		this.number_amount = GiveAmmount;
		this.accountNumber_Select = select_Account;
		Select select = new Select(select_Reciver_Account);
		select.selectByVisibleText(select_Account);
		
	}
	
	public void click_on_Transfer()
	
	{
		transfer_Buttone.click();
	}
	
	public void Verify_After_transfer()
	{
		String xpp = String.format("//*[contains(@id, 'amount') and contains(text(), '$%s.00')]", number_amount);
		System.out.println("sirf dkna h ki value ari h ya nhi = "+number_amount+" or = "+accountNumber_Select+"\n xpath ki value "+xpp);
		WebElement ele = driver.findElement(By.xpath(xpp));
		a = new After_Login(driver);
		if(ele.isDisplayed())
		{
			assertTrue(true);
			String v = a.GFirst_Account();
			
			
			System.out.println("vovo = "+v);
			System.out.println("$"+number_amount+".00 has been transferred from account #"+v+" to account #"+accountNumber_Select);
		}
	}
	
	public static String AmmoutTobe_Transferd()
	{
		return number_amount;
	}
	
	
}
