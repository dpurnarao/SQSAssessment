package SampleProject.Sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class HerokuapphomeTest extends base {
	
	@BeforeTest

	public void initialize() throws IOException
	{
		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void validateurl() throws IOException
	{
		Assert.assertEquals(prop.getProperty("url"),driver.getTitle());
				
	}
	
	
	@Test
	public void validateheader() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals("Challenging DOM",hp.getHeader().getText());
				
	}
	

	@Test
	public void validateImageGithub() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getImageGithub().isDisplayed());
						
	}
	
	@Test
	public void validateLinkelementsselenium() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getLinkelementsselenium().isDisplayed());
				
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	
	}
}
