package SeleniumBootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SeleniumBootcamp@123");
		driver.findElement(By.id("Login")).click();
		
		//Click on toggle menu button from the left corner
				Thread.sleep(9000);
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				//Click view All and click Sales from App Launcher
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				
			//Click on Opportunity tab 
				Thread.sleep(5000);
				WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
			// Search the Opportunity 'Salesforce Automation by Your Name'
				Thread.sleep(3000);
				WebElement search=driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
				search.sendKeys("Salesforce Automation by Dhanusha"+ Keys.ENTER);
				driver.findElement(By.xpath("//div[@role='status']/span")).click();
				
			// Click on  the Dropdown icon and Select Delete
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(2000);
				WebElement success=(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]//span")));
				System.out.println(success.getText());
				
			driver.quit();
						
						
	}

}
