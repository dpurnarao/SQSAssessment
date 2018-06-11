package SampleProject.Sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class ValidateLinksTest extends base {
	
	@BeforeTest

	public void initialize() throws IOException
	{		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));		
	}
	
	@Test
	public void validateurl() throws IOException, InterruptedException
	{		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(prop.getProperty("url"),driver.getTitle());				
	}
	
	
	@Test
	public void validateEditLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getDeletelink().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		//Assert.assertEquals("Challenging DOM",hp.getHeader().getText());				
	}
	

	@Test
	public void validateDeleteLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getDeletelink().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
								
	}
	
	@Test
	public void validateLinkelementsselenium() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getLinkelementsselenium().click();				
	}
	
	public void validateImageGithub() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getImageGithub().click();					
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;	
	}
}
