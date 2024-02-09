package org.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionValid {

	WebDriver driver;
	@Test
	public void validtitlepage(){
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String actualtitle=driver.getTitle();
	    //System.out.println(expectedtitle); //Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in
		String expectedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		//Soft Assertion
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedtitle, actualtitle);
		System.out.println("Hard assertion titlepge passed");
		sa.assertAll();
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Browser closed");
		driver.close();
	}

}


