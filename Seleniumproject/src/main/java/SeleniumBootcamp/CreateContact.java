package SeleniumBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver=new ChromeDriver(options);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://login.salesforce.com/");
driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
driver.findElement(By.id("password")).sendKeys("SeleniumBootcamp@123");
driver.findElement(By.id("Login")).click();
//Thread.sleep(11000);
driver.findElement(By.xpath("//div[contains(@class,'globalCreateContainer')]//a")).click();
driver.findElement(By.xpath("//span[text()='New Contact']")).click();
driver.findElement(By.xpath("//a[text()='--None--']")).click();
driver.findElement(By.xpath("//a[text()='Mr.']")).click();
driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Naveen");
driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys("Elumalai");
driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys("naveen@test.com");

driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
WebElement account=driver.findElement(By.xpath("//div[contains(@class,'createNew')]//span")); 
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView();", account);
account.click();
//accountname.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'createNew')]//span"))).click().build().perform();
driver.findElement(By.xpath("(//span[text()='Account Name']//parent::label)[2]//following::input")).sendKeys("Credits");
driver.findElement(By.xpath("(//button[@title='Save']//span)[2]")).click();
Thread.sleep(3000);
String result=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
System.out.println(result);
 driver.quit();

	
		
		
	}

}
