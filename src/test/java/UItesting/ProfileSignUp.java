package UItesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileSignUp {

	WebDriver driver;
	@Test
public void Signup() throws Exception
{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.myntra.com/");
    
    	Thread.sleep(3000);
    	Actions act=new Actions(driver);	
    	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		String exp= "Signup to Myntra";
	    String actual= driver.findElement(By.xpath("//p[@class='register-title']")).getText();
	    Assert.assertEquals(actual, exp, "invalid");
}

}
