package com.testScripts;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestScript {
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vijay\\Downloads\\geckodriver-v0.12.0-win64\\geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();*/  
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		driver.get("https://www.verizonwireless.com/");
		
		driver.findElement(By.xpath(".//*[@id='pageWrapper']/div[@class='grid section group']/div/nav/ul/li[1]")).click();
		
		driver.findElement(By.xpath(".//*[@id='devices']/div[4]/div/div")).click();
		
		driver.findElement(By.xpath(".//*[@id='device-contracts-wrapper']/div/section[2]")).click();
		
		driver.findElement(By.xpath(".//*[@id='myBtn']")).click();
		
		driver.findElement(By.xpath(".//*[@id='preIntent']/div/input[@class='primary button c-nseCustomizeOnly']")).click();
		
		driver.findElement(By.xpath(".//*[@id='color-selection-form']/label[@for='colorRadio_1']")).click();
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='submit-btn']")).click();		
		
		driver.findElement(By.xpath(".//*[@id='sidebar-container']/div/section/div[@class='clearfix orderSummarySidebarCta']/div/div[@class='plandata_addToCart']/button")).click();
		
		driver.findElement(By.xpath(".//*[@id='costSummary']/div[@class='costSummary_section']")).click();
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShip-firstName']")).sendKeys("VZ");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShip-lastName']")).sendKeys("TOT");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShipEmail']")).sendKeys("v@t.com");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutCustomerPhone']")).sendKeys("4564567890");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShip-address1']")).sendKeys("101 San Fernando Apartments");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShip-address2']")).sendKeys("100");
		
		driver.findElement(By.xpath(".//*[@id='CheckoutShip-city']")).sendKeys("San Jose");
		
		driver.findElement(By.xpath("//div[@class='clearfix o-shipping-address']/div[@class='col-50 input_Container pad10 onlyLeftPad']/div[@class='o-state input_Container pad20 onlyRightPad']/div/a")).click();
		
		driver.findElement(By.xpath("//div[@class='clearfix o-shipping-address']/div[@class='col-50 input_Container pad10 onlyLeftPad']/div[@class='o-state input_Container pad20 onlyRightPad']/div/ul/li[@rel='6']")).click();
		
		driver.findElement(By.xpath(".//*[@id='CaabCheckoutZip']")).sendKeys("95112");
		
		driver.findElement(By.xpath(".//*[@id='Checkout-Shipping-and-Services']/div[@class='background_supporting pad20 noSidePad border_CC onlyTopBorder']/fieldset/div/input[@type='submit']")).click();	
		
		

	}

}
