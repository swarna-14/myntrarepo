package DatadrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenRegistration {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void set()
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.myntra.com/");
	}
	
	@DataProvider
		public static Object[][] regi() throws Exception
	{
		ReadData gd= new ReadData();
		Object data[][]= gd.gettingdata("SignUp");
		return data;
		
	}
	
	 @Test(dataProvider="regi", priority=1)
	public void registration(String EmailAddress, String Password, String MobileNo, String Gender) throws Exception
	{
		
    	//Setup.setprop();
    	Thread.sleep(3000);
    	Actions act=new Actions(driver);	
    	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Your Email Address']")).sendKeys(EmailAddress);
		driver.findElement(By.xpath("//input[@placeholder='Choose Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number (For order status updates)']")).sendKeys(MobileNo);
		WebElement wb=driver.findElement(By.id("male"));
	
		if(wb.equals("male"))
		{
			driver.findElement(By.id("male")).click();
		}
		else
		{
			driver.findElement(By.id("female")).click();
		}
			
	}

}
