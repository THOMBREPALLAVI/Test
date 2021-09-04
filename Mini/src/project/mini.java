package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import Mini.List;



public class mini {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7387693113");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	    driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("technology");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		

			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			Thread.sleep(2000);
			
			List<WebElement> results=driver.findElements(By.xpath("//div[@class=\"s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom\"]");
			List<WebElement> links;
			int size;
			for(WebElement element:results)
			{
				if(links=element.findElements(By.tagName("a"));
				{
					System.out.println(links.get(i).getText());
					
				}
			}

			

			
	}

}
