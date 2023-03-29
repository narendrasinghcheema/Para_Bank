package PARA_Bank.Locaotors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccount_Creat {

	WebDriver driver;
	
	
	
	
	@FindBy(xpath = "//a[text()='Open New Account']")
	WebElement open_new_Account;

	@FindBy(xpath = "//select[contains(@class, 'input ng-pristine ng-untouched ng-valid ng-not-empty') and contains(@id, 'type')]")
	WebElement selectchecking_or_savings;
	
	@FindBy(xpath = "//input[@class='button']")
	WebElement Open_New_Account_Buttone;
	
	@FindBy(xpath = "//a[@class='ng-binding']")
	WebElement Account_numbers;
	
	public NewAccount_Creat(WebDriver IDriver6)
	{
		this.driver = IDriver6;
	}
	
	public void clickon_newAccout_Create()
	{
		open_new_Account.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void select_checking_or_saving_account(String C_or_S)
	{
		Select select = new Select(selectchecking_or_savings);
		select.selectByVisibleText(C_or_S);
		
	}
	public void click_on_creat_new_account_buttone()
	{
		Open_New_Account_Buttone.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Account = Account_numbers.getText();
		System.out.println("Account Number is = "+Account);
		
		StoreAccounts.Accounts.add(Account);
	}
}
