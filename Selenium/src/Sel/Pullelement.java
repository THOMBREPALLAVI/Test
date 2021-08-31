package Sel;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;


public class Pullelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		List<WebElement>all_elements=driver.findElements(By.cssSelector("body:nth-child(2) div.stickynavbar:nth-child(12) div.navbar.relative ul.navbarul > li.movies:nth-child(4)"));
		for(WebElement element : all_elements)
			System.out.println(element.getTagName()+" "+element.getText());
		driver.close();
	}
}
