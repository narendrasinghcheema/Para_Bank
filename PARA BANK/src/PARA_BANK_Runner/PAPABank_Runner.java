package PARA_BANK_Runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PARA_BANK_BrowserSelection.Browser_Selection;
import PARA_Bank.Locaotors.After_Login;
import PARA_Bank.Locaotors.Check_addtion_for_theAccount;
import PARA_Bank.Locaotors.NewAccount_Creat;
import PARA_Bank.Locaotors.PARABank_Login;
import PARA_Bank.Locaotors.StoreAccounts;


public class PAPABank_Runner {

	WebDriver driver;
	PARABank_Login obj1;
	After_Login obj2;
	NewAccount_Creat obj3;
	Check_addtion_for_theAccount obj4;

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
		obj1.Login("ssss", "ssss");
		obj1.VerifyValiddata();
	}
	
	@Test(priority = 4)
	public void Verify_First_Amount()
	{
		obj2 = PageFactory.initElements(driver, After_Login.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Verify_Initial_Money();
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		StoreAccounts.Verify_Accounts_are_Different();
	}
	
	@Test(priority = 7)
	public void check_balance()
	{
		obj4 = PageFactory.initElements(driver, Check_addtion_for_theAccount.class);
		obj4.clickon_Overview();
		obj4.check_Balance(); 
		
	}
	
	@Test(priority = 8)
	public void print_List_of_balance()
	{
		obj4.Balance_in_each_account();
	}
	
	
	
}
