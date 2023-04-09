package PARA_BANK_Runner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PARA_BANK_BrowserSelection.Browser_Selection;
import PARA_Bank.Locaotors.After_Login;
import PARA_Bank.Locaotors.Check_addtion_for_theAccount;
import PARA_Bank.Locaotors.NewAccount_Creat;
import PARA_Bank.Locaotors.PARABank_Login;
import PARA_Bank.Locaotors.StoreAccounts;
import PARA_Bank.Locaotors.Transfer_Funds;
import graphql.language.Value;


public class PAPABank_Runner {

	WebDriver driver;
	PARABank_Login obj1;
	StoreAccounts obj5;
	After_Login obj2;
	NewAccount_Creat obj3;
	Check_addtion_for_theAccount obj4;
	Transfer_Funds obj6;
	

	@Test(priority = 1)
	public void Test_with_invalid_Data()
	{
		driver = Browser_Selection.Select("firefox", "https://parabank.parasoft.com/parabank/index.htm");
		obj1 = PageFactory.initElements(driver, PARABank_Login.class);
		obj1.Login("Narendra", "jfed");
		obj1.Error_verify();
	}
	
	@Test(priority = 2)
	public void Test_with_Blank_Data()
	{
		obj1.Login("", "");
		obj1.Error_verify();
	}
	
	@Test(priority = 3)
	public void Test_with_Valid_Data()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj1.Login("Head", "Head");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj1.VerifyValiddata();
	}
	
	@Test(priority = 4)
	public void Verify_First_Amount()
	{
		obj2 = PageFactory.initElements(driver, After_Login.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Verify_Initial_Money();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.printKrovaluejophle_bnaithis();
		
	}
	
	@Test(priority = 5)
	public void create_an_account()
	{
		obj3 = PageFactory.initElements(driver, NewAccount_Creat.class);
		obj3.clickon_newAccout_Create();
		obj3.select_checking_or_saving_account("SAVINGS");
		obj3.click_on_creat_new_account_buttone();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "create_an_account")
	public void repeat()
	{
		obj3.clickon_newAccout_Create();
		obj3.select_checking_or_saving_account("SAVINGS");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj3.click_on_creat_new_account_buttone();
	}
	
	@Test(priority = 6)
	public void list_Accounts()
	{
		StoreAccounts.prilt_all_accounts();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//obj5.Verify_Accounts_are_Different();
	}
	
	@Test(priority = 7)
	public void check_balance()
	{
		obj4 = PageFactory.initElements(driver, Check_addtion_for_theAccount.class);
		obj4.clickon_Overview();
		obj4.check_Balance(); 
		
	}
	
	@Test(priority = 8)
	public void get_intial_Amount()
	{
		
		double o = 0.0;
		
		String inital_Value = obj2.printKrovaluejophle_bnaithis();
		String V = inital_Value.replace("$", "");
	
		double s = Double.parseDouble(V);
		
		System.out.println("Value of S is = "+s); 
		
		
		double  p = obj4.getsum();
		System.out.println("Value of p is = "+p); 
		
		
		o = s-p;
		
		o = o+p;
		
		String xpppp = String.format("//b[contains(@class, 'ng-binding') and contains(text(), '$%s')]", o);
		
		WebElement balanceVerifying = driver.findElement(By.xpath(xpppp));
		
		if(balanceVerifying.isDisplayed())
		{
			System.out.println("yes the Amount is "+balanceVerifying.getText()+ " Present");
		}else
		{
			System.out.println("No");
 	}
		
	}
	 @Test(priority = 9)
	public void TranferMoney_and_check() throws InterruptedException
	{
		obj6 = PageFactory.initElements(driver, Transfer_Funds.class);
		obj6.click_on_tranfer_buttone();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		List<String> store = StoreAccounts.prilt_all_accounts();
		for(int i=0;i<=store.size();i++)
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
			String value = store.get(1);
			System.out.println("vvvvvv = "+value);
			obj6.interAmountfor_Transfer("700", value);
		}
		
		
		
		obj6.click_on_Transfer();
		obj6.Verify_After_transfer();
	}
}
	

