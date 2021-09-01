package Sel;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//https://www.scientecheasy.com/2019/08/xpath-axes.html/
// http://total-qa.com/xpath-axes-locators-selenium-webdriver-dynamic-html-table/

public class XpathAxesLocators {
 
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
				
		/*
		 // -- Note parent of link <A> is TD not TR; TR is the ancestor
		 //a[contains(text(),'Balaji')]/parent::td
		 
		 //a[contains(text(),'Balaji')]
		 
		 // Ancestor of <A> is TR
		 //a[contains(text(),'Balaji')]/ancestor::tr
		  
		  // ALL the TD's following Balaji - 100's of them
		   * 
		  //a[contains(text(),'Balaji')]/parent::td/following::td
		   
		   // All the items in the Balaji row - sibling TD's of Balaji 
		   //a[contains(text(),'Balaji')]/parent::td/following-sibling::td
	
		   // Get the previous close price of Balaji - specific column
		   //a[contains(text(),'Balaji')]/parent::td/following-sibling::td[2]
	

		 // List all rows above Balaji ; 
		 //  if following is given - after Balaji
		 //a[contains(text(),'Balaji')]/ancestor::tr/preceding-sibling::tr
		 
		 // GET the next TR after Balaji
		 //a[contains(text(),'Balaji')]/ancestor::tr/following-sibling::tr[1]
		 
		 
		 // Select the Balaji row - Note: Descendant of TR is TD
		 //a[contains(text(),'Balaji')]/ancestor::tr/descendant::td
		 
		 // Select the Balaji row - Note: Child of TR is TD
		 //a[contains(text(),'Balaji')]/ancestor::tr/child::td
		 
		 */
		
		
		/**
		 * Solution 1 using Axes Locators
		 */
		System.out.println("Aditya Birla : ");
		WebElement e = driver.findElement(By.xpath("//a[contains(text(),'Aditya Birla')]/parent::td/following-sibling::td[2]"));
		try{
			if(e.isDisplayed())
			{
					String price =  e.getText();
					System.out.println("Stock Price" + price);
			}
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Stock Name Not Exists"+ ex.getMessage());
		}
		
		/**
		 * Solution 2 using findElements()
		 */
		//List<WebElement> trList = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]/a"));
		List<WebElement> trList = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]/a"));
		for(int i=0;i<trList.size();i++)
		{
			if(trList.get(i).getText().contains("Aditya Birla"))
			{
				e = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+(i+1)+"]/td[3]"));
				System.out.println("Stock Price:::" + e.getText());
				break;
			}
		}
		driver.manage().window().maximize();
	}
}
