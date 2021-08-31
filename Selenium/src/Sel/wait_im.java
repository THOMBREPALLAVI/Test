package Sel;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wait.im {
public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();
driver.get("https://www.ebay.com/");

// Implicit wait timeout for 20seconds
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Mobile");

//xpath for search button
WebElement search = driver.findElement(By.xpath("//input[@id='gh-btn']"));

search.click();
}
}