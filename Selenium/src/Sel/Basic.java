package Sel;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class basic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.out.println("test");
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");
	
		
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendkeys("Pallavi");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendkeys("Patil");
		Thread.sleep(2000);
		
		driver.findElement(By.name("//input[@id='UserEmail']")).sendkeys("xyz@gmail.com");
		Thread.sleep(4000);
		
		
		
		driver.findElement(By.xpath("//input[@id='CompanyName']")).sendkeys("tcs");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//select[@id='CompanyEmployees']")).sendkeys("56");
		Thread.sleep(2000);
		
		driver.close();
   
	}

}

