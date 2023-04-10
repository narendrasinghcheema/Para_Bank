package PARA_Bank.Locaotors;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Check_addtion_for_theAccount {

	@FindBy(xpath = "//a[text()='Accounts Overview']")
	WebElement click_on_Account_overview;
	
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(@class, 'ng-binding') and contains(text(),'%s')]")
	WebElement Account_Numberfor_balanceCheck;
	
	@FindBy(xpath = "//tr[@ng-repeat=\"account in accounts\"]/td[2]")
	WebElement check_Ammount;
	
	static List<String> Balacelist = new ArrayList<>();
	
	public Check_addtion_for_theAccount(WebDriver IDriver10)
	{
		this.driver = IDriver10;
	}
	
	public void clickon_Overview()
	{
		click_on_Account_overview.click();
	}
	static List<String> ar =  StoreAccounts.prilt_all_accounts();
	
	/*public void take_Data()
	{
		for(int i=0;i<StoreAccounts.Accounts.size(); i++)
		{
			check_Balance(StoreAccounts.Accounts.get(i));
		}
	}*/
	
	public void check_Balance()
	{
		
		for(int i=0;i<ar.size(); i++)
		{
			String xp = String.format("//a[contains(@class, 'ng-binding') and contains(text(),'%s')]", ar.get(i));
			
			String xpp = String.format("//a[contains(@class, 'ng-binding') and contains(text(),'%s')]/ancestor::tr/td[2]", ar.get(i));
			
			WebElement ele = driver.findElement(By.xpath(xp));
			String text = ele.getText();
			if(ele.isDisplayed())
			{ 
				WebElement check = driver.findElement(By.xpath(xpp));
				String Balance = check.getText();
				System.out.println("yes the Account is display = "+text+" and the balance is = "+Balance);
				Balacelist.add(Balance);
				
			}
			
		}
		
	}
	
	
	public double getsum()
	{
		double sum = 0.0;
		
		for(int i=0;i<=Balacelist.size()-1;i++)
		{
			String valuefromclass = Balacelist.get(i);
			System.out.println("try krne k liye = "+valuefromclass);
			String replace = valuefromclass.replace("$", "");
			double d = Double.parseDouble(replace);
			
			System.out.println("replace hone ka bad = "+d);
			
			
			sum += d;
		}
		
		
		return sum;
		
	}
	
	
	public String Value()
	{
		String getValue = "";
		for(int i=0;i<=ar.size();i++)
		{
			getValue = ar.get(i);
		}
		return getValue;
	}
	
	public static  String Fetch2nd_Account_Balance()
	{
		String Account_2nd = "";
		for(int i=0;i<Balacelist.size();i++)
		{
			if(i == 1)
			{
				System.out.println("Balance for Second Account = "+Balacelist.get(i));
				String Account2nd = Balacelist.get(i);
				Account_2nd = Account2nd;
			}
			
		}
		return Account_2nd;
	}
	
}
