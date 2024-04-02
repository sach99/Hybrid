package com.quafox.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.quafox.base.Base;
import com.quafox.pages.HomePage;
import com.quafox.pages.LoginPage;
import com.quafox.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;
	ExtentReports extentReport;
    @BeforeMethod
	public void setup() throws IOException
	{
    	loadPropertiesFile();
    	driver= initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
    	HomePage homePage= new HomePage(driver);
    	homePage.clickOnMyAccount();
    	homePage.selectLoginOption();   
  		
		
		
	}
    
   

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
    @Test(priority=1)
	public void verifyLoginWithValidCredentials() throws InterruptedException
	{
    	
		System.out.println("Test Case 1");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.performLogin("sachintestselenium1591@gmail.com", "12345");
		
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
        
	}
    
    @Test(priority=2)
    public void verifyLoginWithInvalidCredentials() throws InterruptedException
	{
    	
		System.out.println("Test Case 2");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();			
		
		Thread.sleep(10000);
		String actualText =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(actualText, prop.getProperty("emailPasswordNoMatchWarning"));
	}
    
    @Test(priority=3)
    public void verifyLoginWithInvalidUsername() throws InterruptedException
	{
    	
		System.out.println("Test Case 3");
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Utilities.generateEmailWithTimeStamp()");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualText =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(actualText, prop.getProperty("emailPasswordNoMatchWarning"));
		
	}
    
    @Test(priority=4)
    public void verifyLoginWithInvalidPassword() throws InterruptedException
	{
    	
		System.out.println("Test Case 4");
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sachintestselenium@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualText =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(actualText, prop.getProperty("emailPasswordNoMatchWarning"));
		
	}
    
   
    
}
