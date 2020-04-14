package FunctionalTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Storedvalue {
	
	WebDriver driver;
//	public void setup()
//	{
		
//		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
//    	driver= new ChromeDriver();
//    	driver.manage().window().maximize();
//    	driver.get("https://www.myntra.com/");
//	}
	
	public static void expectedvalue()
	{
		//String wnurl="https://www.myntra.com/tops?sort=new";
		String wnurl = null;
		int value=42036 ;
		if(wnurl.equals("https://www.myntra.com/tops?sort=new"))
		{
			
			System.out.println(value);
		}
		
	}

}
