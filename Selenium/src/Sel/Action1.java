package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import java.lang.Enum;



public class Action1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		Actions act=new Actions(driver);
        WebElement move = driver.findElement(By.xpath("//*[@id='nav-link-prime']/span[1]"));
		act.moveToElement(move).build().perform();
		Thread.sleep(2000);
		WebElement txtbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		act.moveToElement(txtbox).click().sendKeys("hello").doubleClick().build().perform();
		//txtbox.sendKeys(Keys.SPACE);
		//act.moveToElement(txtbox).click().keyDown(Keys.SHIFT);
		//click().keyDown(Keys.SHIFT).sendKeys("Hello").
        //act.moveToElement(txtbox).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
		Thread.sleep(3000);
		
		act.moveToElement(txtbox).doubleClick().build().perform();
		Thread.sleep(3000);
		//driver.close();
		System.out.println("End of code");


}
}