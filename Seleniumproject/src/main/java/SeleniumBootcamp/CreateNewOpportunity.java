package SeleniumBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity {

	
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
		WebElement name=driver.findElement(By.xpath("(//label[text()='Opportunity Name'])//following-sibling::div//input"));
		name.sendKeys("Salesforce Automation by Dhanusha");
		Thread.sleep(3000);
		String opportunityName=name.getAttribute("value");
		//System.out.println(opportunityName);
		driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input")).sendKeys("7/9/2022");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement abc = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		Thread.sleep(2000);
		abc.click();
		Thread.sleep(5000);
		
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='Needs Analysis']"))).click().perform();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();", ele);
		
		Thread.sleep(5000);
		Boolean result=driver.findElement(By.linkText(opportunityName)).isDisplayed();
		if(result==true)
			{
			System.out.print(opportunityName+" is created");
			}
		driver.quit();
		
		

	}

	private static String getText(WebElement name) {
		// TODO Auto-generated method stub
		return null;
	}

}
