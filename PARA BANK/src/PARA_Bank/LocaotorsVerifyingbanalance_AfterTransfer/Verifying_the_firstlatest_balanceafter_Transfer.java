package PARA_Bank.LocaotorsVerifyingbanalance_AfterTransfer;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PARA_Bank.Locaotors.After_Login;
import PARA_Bank.Locaotors.Check_addtion_for_theAccount;
import PARA_Bank.Locaotors.Transfer_Funds;

public class Verifying_the_firstlatest_balanceafter_Transfer {

	WebDriver driver;
	
	public Verifying_the_firstlatest_balanceafter_Transfer(WebDriver Idrover120)
	{
		this.driver = Idrover120;
	}
	
	public void VerifyingTrasectionsfor_firstAccount()
	{
		double Aftervalue = 0.0;
		double verifyingAmount = 0.0;
		String price = After_Login.printKrovaluejophle_bnaithis();
		String Prices = price.replace("$", "");
		
		double initial_price = Double.parseDouble(Prices);
		String first_account = After_Login.GFirst_Account();
		
		System.out.println("Price is = "+initial_price+" and Account number is = "+first_account);
		
		double restAccounttotal_Balanxe = Check_addtion_for_theAccount.getsum();
		System.out.println("total balance for rest account = $"+restAccounttotal_Balanxe+"0");
		
		Aftervalue = initial_price - restAccounttotal_Balanxe;
		
	

		//=====================================================
		String AmountTranser = Transfer_Funds.AmmoutTobe_Transferd();
		double Amount_Transfer = Double.parseDouble(AmountTranser);
	
		
		verifyingAmount = Aftervalue - Amount_Transfer;
	
		
		String xpp = String.format("//*[contains(@class, 'ng-binding') and contains(text(),'$%s0')]", verifyingAmount);
		System.out.println("XPP = "+xpp);
		
		WebElement ele = driver.findElement(By.xpath(xpp));
		if(ele.isDisplayed())
		{
			assertTrue(true);
			System.out.println("Now the Balance for first which is ="+first_account+"\nand the balamce is Now = $"+verifyingAmount+"0");
		}
	}
}
