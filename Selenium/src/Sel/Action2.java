package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Action2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);

		Actions act=new Actions(driver);

		WebElement src = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		
	    WebElement trgt = driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(2000);

	    WebElement droptext = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));

	    act.doubleClick(droptext).build().perform();
		Thread.sleep(2000);
		
	    act.dragAndDrop(src,trgt).build().perform();
	    Thread.sleep(2000);
	    
	    act.contextClick(src).build().perform();
	    System.out.println("Program over");
	    Thread.sleep(2000);
	    driver.close();

	}

}
