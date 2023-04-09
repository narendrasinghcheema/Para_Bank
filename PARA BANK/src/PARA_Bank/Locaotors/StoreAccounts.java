package PARA_Bank.Locaotors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class StoreAccounts {

	
	
	static WebDriver driver;
	
	
	
	static List<String> Accounts = new ArrayList<>();
	
	public static List<String> prilt_all_accounts()
	{
		
		for(int i=0;i<Accounts.size(); i++)
		{
			System.out.println(Accounts.get(i));
		}
		return Accounts;
	}
	
	
	public void Verify_Accounts_are_Different()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		for(int i = 0; i<Accounts.size(); i++)
		{
			for(int j = i+1; j<Accounts.size(); j++)
			{
				if(Accounts.get(i) == Accounts.get(j))
				{
					System.out.println("numbers are not same \n and the numbers are = ");
					System.out.println("i = "+Accounts.get(i));
					System.out.println("j = "+Accounts.get(j));
				}else if(!(Accounts.get(i) == Accounts.get(j)))
				{
					System.out.println("Numbers are different "+Accounts.get(i));
				}
			}
		}
	}
}