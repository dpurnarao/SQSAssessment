package SampleProject.Sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void validateurl() throws IOException, InterruptedException
	{		
		Assert.assertEquals(prop.getProperty("url"),driver.getCurrentUrl());				
	}
	
	
	@Test(priority=1)
	public void validateEditLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getEditlink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#edit",driver.getCurrentUrl());				
	}
	

	@Test(priority=2)
	public void validateDeleteLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getDeletelink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#delete",driver.getCurrentUrl());
								
	}
	
	@Test(priority=3)
	public void validateImageGithub() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getImageGithub().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals("https://github.com/tourdedave/the-internet",driver.getCurrentUrl());
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=4)
	public void validateLinkelementsselenium() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getLinkelementsselenium().click();	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//String xx = driver.findElement(By.xpath("//html/body/header/div/div").getText());
		//System.out.println();
		//Assert.assertEquals("http://elementalselenium.com/",driver.getCurrentUrl());
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		driver=null;	
	}
}
