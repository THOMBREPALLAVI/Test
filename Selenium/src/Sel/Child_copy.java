package Sel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Child_copy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\worksoft\\geckodriver\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		driver.get("https://the-internet.herokuapp.com/windows");

		String parent = driver.getWindowHandle();

		driver.findElement(By.partialLinkText("Click")).click();
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Click")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		driver.findElement(By.partialLinkText("Elem")).click();
		Set<String> ch = driver.getWindowHandles();
		Iterator<String> it = ch.iterator();

		while (it.hasNext()) {
			String chwin = it.next();
			if (!parent.equals(chwin)) {
				driver.switchTo().window(chwin);
				System.out.println("Child Window handle is:"+chwin);
				System.out.println("Child Title is:" + driver.getTitle());
				Thread.sleep(2000);
				driver.close();
			}
			driver.switchTo().window(parent);
			Thread.sleep(2000);

		}
		System.out.println("Parent Window handle is:"+parent);
		System.out.println("Parent Title is:" + driver.getTitle());
	}

}
