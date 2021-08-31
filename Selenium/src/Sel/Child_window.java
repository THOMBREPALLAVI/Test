package Sel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Child_window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		//driver.get(url);
		
		//driver.get("https://accounts.google.com/SignUp?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount");
		
		driver.get("https://accounts.google.com/");
		driver.findElement(By.linkText("Privacy")).click();
		
		System.out.println("Title of the main window is:"+driver.getTitle());
		
		//Get all window handles opened and keep it in a set ids
		//Set is a java feature
		//First window handle will be parentid - main window opened
		//later on all the child ids will be there in the Set
		//For help check this out - https://study.com/academy/lesson/how-to-iterate-set-in-java.html
		//Set<String> ids = driver.getWindowHandles();
		
		driver.getWindowHandles();
		
		Set<String> ids = driver.getWindowHandles();
		
		//Iterator can be used to iterate in the Set ids
		Iterator<String>it = ids.iterator();
		
		//initially string will be in top
		//first time it.next takes to parent id
		//next tiem takes to child id
		String parentid = it.next();
		String childid = it.next();
		
		System.out.println(" ");
		System.out.println("Parent id for reference is: "+parentid);
		System.out.println("child id for reference is: "+childid);
		driver.switchTo().window(childid);
		System.out.println(" ");
		
		System.out.println("Title after switchto-child window : "+driver.getTitle());
		//Not getting new title - its printing blank in Firefox- need to check
		//however, in Chrome it is working fine
		//System.out.println(driver.getTitle());
				
		driver.switchTo().window(parentid);
		System.out.println("Title after switchto-parent win : "+driver.getTitle());
		
		System.out.println("End of program ");
	}

}