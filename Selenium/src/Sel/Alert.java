package Sel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://www.tizag.com/javascriptT/javascriptalert.php");
		
		driver.findElement(By.xpath("html/body[1]/table[3]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[3]/pre[1]"));
		//Thread.sleep(2000);
		String alerttxt;
		alerttxt = driver.switchTo().alert().getText();
		System.out.println(alerttxt);
		driver.switchTo().alert().accept();
	


	}

}
