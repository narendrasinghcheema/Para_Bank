package PARA_Bank.LocaotorsVerifyingbanalance_AfterTransfer;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PARA_Bank.Locaotors.Check_addtion_for_theAccount;
import PARA_Bank.Locaotors.StoreAccounts;
import PARA_Bank.Locaotors.Transfer_Funds;
import graphql.Assert.*;

public class Checking_the_Balance {


	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Accounts Overview']")
	WebElement Account_overview;
	
	static double c = 0.0;


	public Checking_the_Balance(WebDriver IDriver100)
	{
		this.driver = IDriver100;
	}
	
	public void checkfor_Balace()
	{
		
		String Second_ndBalance = Check_addtion_for_theAccount.Fetch2nd_Account_Balance();

		
		String RemoveDollerfromSecond =  Second_ndBalance.replace("$", "");
		
		double AccountBalance_2nd = Double.parseDouble(RemoveDollerfromSecond);
		System.out.println("Second_ndBalance is = "+AccountBalance_2nd);
		
		String AmountTransferd = Transfer_Funds.AmmoutTobe_Transferd();
		
		
		double Amount_Tranfer =  Double.parseDouble(AmountTransferd);
		System.out.println("Amount to be tranferd = "+Amount_Tranfer);
		
		c = Amount_Tranfer + AccountBalance_2nd;
		System.out.println("Balance in second Account is = "+c);
		
		
		String A_Number = StoreAccounts.GetSecondAccount();
		
		System.out.println("Now the Balance for the Account which is = "+A_Number+" and the Balance is = $"+c+"0");
	}
	
	public void Verifying_the_Account_Balance()
	{
		String A_Number = StoreAccounts.GetSecondAccount();
		Account_overview.click();
		String xp = String.format("//*[contains(@class, 'ng-binding') and contains(text(), '$%s0')]", c);
		WebElement ele = driver.findElement(By.xpath(xp));
		
		if(ele.isDisplayed())
		{
			assertTrue(true);
			System.out.println("yes the given Balance for the account which is = "+A_Number+" and the balance for the same Accout is now = "+c);
		}else
		{
			assertFalse(false);
		}

	}
}
