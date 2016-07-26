package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testng.Locators;

public class NewTest {

  WebDriver driver=SeleniumBase.getDriver();
  	
	@BeforeTest
	public void beforeTest(){
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  driver.navigate().to("https://www.facebook.com/");
		  driver.manage().window().maximize();
	  }

	@AfterTest
	public void afterTest(){
		driver.close();
	}


  @Test(description="Home_001", groups = {"Regression"})
  public void firstTest() {
	  WebElement inputEmail=driver.findElement(By.xpath(Locators.InputEmail));
		inputEmail.sendKeys("priyankarocks3784@yahoo.com");
		WebElement inputPass=driver.findElement(By.xpath(Locators.InputPassword));
		inputEmail.sendKeys("9979419955PRIYA");
		WebElement btnLogin=driver.findElement(By.xpath(Locators.btnLogin));
		btnLogin.click();
		
  }
}
