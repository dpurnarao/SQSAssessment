package SampleProject.Sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class Tablevalidations extends base {
	
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
	
	
	@Test
	public void validateTableheader() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals("Lorem Ipsum Dolor Sit Amet Diceret Action",hp.getTableHeaders().getText());
	}
	
	@Test
	public void validateTableheadercount() throws IOException
	{
		List<WebElement> headings=driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th"));
		assertEquals(7, headings.size());
	}
	
	@Test
	public void validaterowscount() throws IOException
	{
		List<WebElement> rows= driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr"));
		assertEquals(10, rows.size());
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
