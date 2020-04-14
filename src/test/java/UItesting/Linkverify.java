package UItesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Linkverify {

	WebDriver driver;
	@Test
	public void links() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.myntra.com/");
    	
    	Thread.sleep(3000);
    	Actions act=new Actions(driver);	
    	act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Men')]"))).build().perform();
		Thread.sleep(3000);	
		String actual= driver.findElement(By.xpath("//a[contains(text(),'Topwear')]")).getText();
		String exp="Topwear";
		Assert.assertEquals(actual, exp,"invalid");
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Women')]"))).build().perform();
		Thread.sleep(3000);	
		String actual1= driver.findElement(By.xpath("//a[contains(text(),'Western Wear')]")).getText();
		String exp1="Western Wear";
		Assert.assertEquals(actual1, exp1,"invalid");
		act.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main'][contains(text(),'Kids')]"))).build().perform();
		Thread.sleep(3000);	
		String actual2= driver.findElement(By.xpath("//a[contains(text(),'Boys Clothing')]")).getText();
		String exp2="Boys Clothing";
		Assert.assertEquals(actual2, exp2,"invalid");
		act.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main'][contains(text(),'Home & Living')]"))).build().perform();
		Thread.sleep(3000);	
		String actual3= driver.findElement(By.xpath("//a[contains(text(),'Flooring')]")).getText();
		String exp3="Flooring";
		Assert.assertEquals(actual3, exp3,"invalid");
		act.moveToElement(driver.findElement(By.xpath("//body/div[@id='desktop-headerMount']/div/div/header[@id='desktop-header-cnt']/div[@class='desktop-bound']/nav[@class='desktop-navbar']/div[@class='desktop-navLinks']/div[5]/div[1]"))).build().perform();
		Thread.sleep(3000);	
		String actual4= driver.findElement(By.xpath("//div[contains(text(),'Brands For Him')]")).getText();
		String exp4="Brands For Him";
		Assert.assertEquals(actual4, exp4,"invalid");
		Thread.sleep(3000);
	}

	
}
