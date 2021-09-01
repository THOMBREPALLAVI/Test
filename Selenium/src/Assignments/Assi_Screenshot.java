package Assignments;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class Assi_Screenshot {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
		        driver.manage().window().maximize();
				driver.get("https://www.amazon.in/");
				//driver.findElement(By.xpath(""))
				
				TakesScreenshot scrshot = (TakesScreenshot)driver;
				File scrfile = scrshot.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrfile, new File(".\\amazon.png"));
				
				
				//String destfle = "C:\\Users\\Sai\\Pictures\\Screenshots";
				//File targetfile = new File(destfile);
				//Files.copy(scrfile.targetfile);
				//System.out.println("End of Code");

		}

	}

	}

}
