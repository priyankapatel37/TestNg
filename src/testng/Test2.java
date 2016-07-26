package testng;

import java.util.concurrent.TimeUnit;

import javax.xml.bind.Validator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Test2 {
WebDriver driver=SeleniumBase.getDriver();
  	
	@BeforeTest
	public void beforeTest(){
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  driver.navigate().to("https://www.google.co.in/?gws_rd=ssl");
		  driver.manage().window().maximize();
	  }

	@AfterTest
	public void afterTest(){
		driver.close();
	}

	@DataProvider(name = "test2")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", new Integer(36) },
	   { "Anne", new Integer(37)},
	 };
	}
	 
	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test2", groups = {"Smoke"})
	public void verifyData1(String n1, Integer n2) {
	 System.out.println(n1 + " " + n2);
	}
	
	@Test(parameters = "name", groups = {"Smoke"})
	public void verifyData2(String na) {
	 System.out.println("name " + na);
	 Assert.assertEquals(na.endsWith("a"), na.endsWith("a"));
	 
	 Reporter.log(na);
	}

  @Test(description="Home_002", dependsOnMethods = {"verifyData1"}, groups = {"Regression"})
  public void firstTest() {
	  WebElement inputEmail=driver.findElement(By.xpath(Locators.inputSearch));
		inputEmail.sendKeys("facebook");
		
		WebElement btnS=driver.findElement(By.xpath(Locators.btnSearch));
		btnS.click();
		
  }

}
