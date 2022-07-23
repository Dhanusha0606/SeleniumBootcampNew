package SeleniumBootcamp;





import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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

public class SortOportunities {
static String sortelement;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, ParseException {
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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//a[@title='Opportunities']//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class,'uiScroller')]")).sendKeys(Keys.END);
		
		Thread.sleep(3000);
		
		List<WebElement> colname=  driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]/tbody/tr/td[6]"));
	
		Thread.sleep(2000);
		String [] beforesort= new String[colname.size()];
		System.out.println("----------Before sort-----------");
		for(int i=0;i<colname.size();i++)
		{
			beforesort[i]= colname.get(i).getText();	
			System.out.println(beforesort[i]);
			
		}
		System.out.println("--Sorting in IDE------");
		String [] comparesort= new String[colname.size()];
		for(int i=0;i<colname.size();i++)
		{	
//Using date formatter as date was not sorting correctly when its in M/d/yyyy format using Array sort method
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date date = (Date)formatter.parse(beforesort[i]);
			formatter = new SimpleDateFormat("MM/dd/yyyy");
			comparesort[i] = formatter.format(date);
		}
			Arrays.sort(comparesort);
			//sortelement=comparesort[i];
			//System.out.println(comparesort[i]);
			
			
		Actions closedate=new Actions(driver);
		//closedate.moveToElement(driver.findElement(By.xpath("//span[text()='Close Date']"))).doubleClick().build().perform();
		closedate.moveToElement(driver.findElement(By.xpath("//span[text()='Close Date']"))).click().build().perform();
		Thread.sleep(2000);
		closedate.moveToElement(driver.findElement(By.xpath("//span[text()='Close Date']"))).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'uiScroller')]")).sendKeys(Keys.END);
		Thread.sleep(2000);
		colname=  driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]/tbody/tr/td[6]"));
		String [] aftersort= new String[colname.size()];
		System.out.println("----------After sort-------");
		
		//ArrayList<String> obtainedlist=new ArrayList<>();
		for(int i=0;i<colname.size();i++)
		{
			aftersort[i]= colname.get(i).getText();
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date date = (Date)formatter.parse(aftersort[i]);
			formatter = new SimpleDateFormat("MM/dd/yyyy");
			aftersort[i] = formatter.format(date);
			System.out.println(aftersort[i]);
			
		}
		
		Assert.assertEquals(comparesort,aftersort);
		System.out.println("Sorting Successful");
	}

}
