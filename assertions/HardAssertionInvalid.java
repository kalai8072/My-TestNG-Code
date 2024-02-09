package org.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HardAssertionInvalid {
	

	 WebDriver driver;
	@Test(priority=1)
	public void validtitlepage(){
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String actualtitle=driver.getTitle();
	    //System.out.println(expectedtitle); //Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in
		String expectedtitle = " Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("Hard assertion titlepge failed");
	}
	@Test(priority=2)
	public void anotherwindow() {
		
		driver.get("https://www.amazon.in/");
		System.out.println("Browser opened");
		
	}
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}

}


