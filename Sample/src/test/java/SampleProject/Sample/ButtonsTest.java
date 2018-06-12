package SampleProject.Sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class ButtonsTest extends base {
	

	@BeforeTest

	public void initialize() throws IOException
	{
		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test (priority=1)
	public void validateurl() throws IOException, InterruptedException
	{		
		Assert.assertEquals(prop.getProperty("url"),driver.getCurrentUrl());				
	}
	
	
	/*@Test
	public void validateButtonCount1() throws IOException
	{	
		Homepage hp = new Homepage(driver);
		List<WebElement> list1=hp.getButtonCount1();
		if(Optional.ofNullable(list1)!=null)
		assertEquals(3,list1.size());
	}
		*/
	
	@Test
	public void validateButton1() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getImageGithub().isDisplayed());
						
	}
	
	@Test
	public void validateButton2() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getLinkelementsselenium().isDisplayed());
				
	}
	
	@Test
	public void validateButton3() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getLinkelementsselenium().isDisplayed());
				
	}
	
	@Test
	public void validateButtonCount() throws IOException
	{		
		List<WebElement> list=driver.findElements(By.xpath("//a[contains(@class,'button')]"));
		if(Optional.ofNullable(list)!=null)
		assertEquals(3,list.size());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	
	}
}
