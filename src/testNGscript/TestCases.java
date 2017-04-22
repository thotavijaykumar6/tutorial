package testNGscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
	
	static WebDriver driver;
	
	@BeforeTest
	public void loadHomePage(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vijay\\Downloads\\geckodriver-v0.12.0-win64\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.get("https://www.verizonwireless.com/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void verifyDriverOnHomePage(){
		String status = driver.findElement(By.xpath(".//*[@id='vgn_wireless']")).getAttribute("class");
		Assert.assertEquals(status, "o-active");
		
	}
	
	
	@Test(priority = 1)
	public void click(){
		driver.findElement(By.xpath(".//*[@id='pageWrapper']/div[@class='grid section group']/div/nav/ul/li[1]")).click();
		
	}
	
	
	@AfterTest
	public void closeDriver(){
		driver.close();
	}

}
