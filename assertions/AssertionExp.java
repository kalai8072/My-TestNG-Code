package org.assertions;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionExp {
	
	WebDriver driver;

	 @BeforeMethod
	 void openingBrowser() {

	  // opening browser
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();

	  // get the url of the site
	  driver.get("https://magento.softwaretestingboard.com/");

	  // maximize the window
	  driver.manage().window().maximize();
	 }

	 @Test(priority = 1)
	 void loginValid() {

	  // click sign-in link
	  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

	  // enter username and password
	  driver.findElement(By.id("email")).sendKeys("vijaydinesh52524@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("dinesh@8072");

	  // click sign - in buuton
	  driver.findElement(By.xpath("//button[@class='action login primary']//span[text()='Sign In']")).click();
	  String tiltpage = driver.getTitle();
	  //System.out.println(tiltpage);//Customer Login
	  Assert.assertEquals(tiltpage, "Home Page", "test passed");
	 }
	 @Test (priority=2)
	 void invalidlogin() {
		// click sign-in link
		  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

		  // enter username and password
		  driver.findElement(By.id("email")).sendKeys("rashikamoorthy@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("Naini@202");

		  // click sign - in buuton
		  driver.findElement(By.xpath("//button[@class='action login primary']//span[text()='Sign In']")).click();
		  String tiltpage = driver.getTitle();
		  //System.out.println(tiltpage);// homepage
		  Assert.assertEquals(tiltpage, "Customer Login" , "test failed");
		 }
	 @AfterMethod
	 void close() {
		 driver.close();
	 }
		 
	 }
