package Sel;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Assi_Screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("https://www.w3schools.com/");
			
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			File scrfile = scrshot.getScreenshotAs(OutputType.FILE);
			String destfle = "C:\\Users\\Sai\\Pictures\\Screenshots";
			File targetfile = new File(destfile);
			Files.copy(scrfile.targetfile);
			System.out.println("End of Code");

	}

}
