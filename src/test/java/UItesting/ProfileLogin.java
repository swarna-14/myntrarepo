package UItesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileLogin {
	
WebDriver driver;
//HomePage hp=new HomePage();
    @Test
	public void login() throws InterruptedException
	{
	
		//hp.link();
    	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.myntra.com/");
    	//Setup.setprop();
    	Thread.sleep(3000);
    	Actions act=new Actions(driver);	
    	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'log in')]")).click();
	    String exp= "Login to Myntra";
	    String actual= driver.findElement(By.xpath("//p[@class='login-title']")).getText();
	    Assert.assertEquals(actual, exp, "invalid");
	}
}
