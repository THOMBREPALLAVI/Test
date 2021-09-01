package Sel;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			File scrfile = scrshot.getScreenshotAs(OutputType.FILE);
			String destfile = "C:\\Users\\Sai\\Pictures\\Screenshots\\w3school.png";
			File targetfile = new File(destfile);
			Files.copy(scrfile,targetfile);
			System.out.println("End of Code");
			driver.close();
			
			//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshotFile,new File(".//screenshot//screenshot.png"));

	}

}
