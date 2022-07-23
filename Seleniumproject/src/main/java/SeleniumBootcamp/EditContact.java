package SeleniumBootcamp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SeleniumBootcamp@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Actions clickcontact=new Actions(driver);
		clickcontact.moveToElement(driver.findElement(By.xpath("//span/p[text()='Contacts']"))).click().build().perform();
		List<WebElement> storecontact=driver.findElements(By.xpath("//table/tbody/tr/th"));
		String[] contactlist= new String[storecontact.size()];
		for(int i=0;i<storecontact.size();i++)
		{
			contactlist[i]=storecontact.get(i).getText();
			System.out.println(contactlist[i]);
		}
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Naveen Elumalai"+ Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table/tbody/tr/td[8]//div[contains(@class,'forceVirtualActionMarker')]//a")).click();
		driver.findElement(By.xpath("//div[contains(@class,'forceActionsDropDownMenuList')]/div/ul/li[1]/a")).click();
		WebElement title=driver.findElement(By.xpath("//input[@name='Title']"));
		title.clear();
		title.sendKeys("Test");
		WebElement birthdate=driver.findElement(By.xpath("//input[@name='Birthdate']"));
		JavascriptExecutor js=driver;
		js.executeScript("arguments[0].scrollIntoView();", birthdate);
		birthdate.clear();
		birthdate.sendKeys("6/6/1993");
		driver.findElement(By.xpath("//label[text()='Lead Source']//following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
		WebElement phn=driver.findElement(By.xpath("//input[@name='Phone']"));
		
		js.executeScript("arguments[0].scrollIntoView();", phn);
		String phonenumber="1234344563";
		phn.clear();
		phn.sendKeys("1234344563");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		String result=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
		System.out.println(result);
		String enteredphonenumber=driver.findElement(By.xpath("//span[contains(@class,'forceOutputPhone')]")).getText();
	   Assert.assertEquals(phonenumber, enteredphonenumber);
		driver.quit();
		}
		
	}


