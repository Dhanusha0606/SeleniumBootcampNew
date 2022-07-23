package SeleniumBootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunityWithoutMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(4000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SeleniumBootcamp@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='New']//div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input")).sendKeys("7/11/2022");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement validation= driver.findElement(By.xpath("(//label[text()='Opportunity Name'])//following-sibling::div//input"));
		String validationMessage= (String) js.executeScript("return arguments[0].validationMessage;", validation);
		
		WebElement validation2=driver.findElement(By.xpath("//div[contains(@id,'help-text')]"));
		String validationMessage2= validation2.getText();
		
		System.out.println(validationMessage+ " :Name ");
		System.out.println(validationMessage2+ " :Stage ");
		
		driver.quit();
		
	}

}
