package UItesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Setup;

public class HomePage {
	
    WebDriver driver;
    
    
	@Test
	public void link() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.myntra.com/");
	//Setup.setprop();
	Thread.sleep(3000);
	Actions act=new Actions(driver);	
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div"))).build().perform();
	String wb= driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).getText();
	String exp="SIGN UP";
	String actual= wb;
	Assert.assertEquals(actual, exp,"invalid");
	}
}
