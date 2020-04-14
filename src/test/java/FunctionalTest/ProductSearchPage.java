package FunctionalTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchPage {
	
	WebDriver driver;
	//Storedvalue pr;
	
	@Test(priority=0)
	public void productsearch()
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.myntra.com/");
    	
    	String exp="";
    	boolean act=driver.findElement(By.className("desktop-submit")).isEnabled();
    	//Assert.assertEquals(act, exp);
    	System.out.println(act);
    	
   	    driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Tops");
   	    driver.findElement(By.className("desktop-submit")).click();
    	String expecres= "https://www.myntra.com/tops";
   	    String actres=driver.getCurrentUrl();
  	    Assert.assertEquals(actres, expecres, "invalid");
	}
	@Test(priority=1)
	public void sortby()
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"))).build().perform();
		
		driver.findElement(By.xpath("//*[contains(text(),\"What's New\")]")).click();
		String expr="https://www.myntra.com/tops?sort=new";
		String actr=driver.getCurrentUrl();
		Assert.assertEquals(actr, expr, "invalid");
		
	}
	
	@Test (priority=2)
    public void verifycount()
    	{
    	String value= driver.findElement(By.xpath("//span[@class='title-count']")).getText();
    	System.out.println(value);
    	
    	}
    	
//	@Test(priority=3)
//	public void choosesize()
//	{
//		List checkboxes=driver.findElements(By.xpath("//label[contains(text(),'24')]"));
//		System.out.println(checkboxes.size());
//		for(int i=0;i<checkboxes.size();i++)
//		{
//			checkboxes.get(i).click();
//		}
//		
//	}
	
	

}
