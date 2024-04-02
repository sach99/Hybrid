package com.quafox.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quafox.base.Base;
import com.quafox.utils.Utilities;

public class RegisterTest extends Base {
	WebDriver driver;
    @BeforeMethod
	public void setup() throws IOException
	{
    	loadPropertiesFile();
    	driver= initializeBrowserAndOpenApplication("chrome");		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyRegisteringAccountWithMandatoryFields() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		Assert.assertEquals(actualText, prop.getProperty("accountSuccessfullyCreatedHeading"),"Text is not matching");
		
	}
	
	@Test
	public void verifyRegisteringAccountWithAllFields() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("sachin");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		Assert.assertEquals(actualText, "Your Account Has Been Created!","Text is not matching");
		
	}
	
	@Test
	public void verifyRegisteringAccountWithDuplicateEmail() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("sachin");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sachintestselenium1591@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		
		Assert.assertEquals(actualText, "Warning: E-Mail Address is already registered!","Text is not matching");
		
	}
	
	  

}
