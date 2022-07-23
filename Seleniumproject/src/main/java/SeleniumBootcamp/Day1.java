package SeleniumBootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
ChromeOptions options= new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver=new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://login.salesforce.com/");
driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");


	}

}
