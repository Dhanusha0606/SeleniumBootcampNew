package SeleniumBootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Tuna@123");
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
				
		//Click on the Dropdown icon and Select Edit
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		//Choose close date as Tomorrow date
		Thread.sleep(3000);
		WebElement date=driver.findElement(By.xpath("(//label[text()='Close Date'])//following-sibling::div//input"));
		date.clear();
		date.sendKeys("7/11/2022" + Keys.TAB);
		
		//Select 'Stage' as Perception Analysis
		Thread.sleep(3000);
		Actions actions =new Actions(driver);
		driver.findElement(By.xpath("//label[text()='Stage']//following::span")).click();
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='Perception Analysis']"))).click().perform();
		
		//Select Deliver Status as In Progress
		Thread.sleep(3000);
		WebElement status=driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']//following::span"));
		js.executeScript("arguments[0].scrollIntoView();", status);
		status.click();	
		actions.moveToElement(driver.findElement(By.xpath("//span[@title='In progress']"))).click().perform();
		
		//Enter Description as SalesForce
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");
		
		//Click on Save and Verify Stage as Perception Analysis
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		
		driver.quit();
		
		
		
		
		
		
	}

}
