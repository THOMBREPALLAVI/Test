package Sel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// https://stackoverflow.com/questions/45288842/how-to-set-proxy-for-chrome-browser-in-selenium-using-java-code

public class Proxy {

	
	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32//chromedriver.exe");	


String proxy = "127.0.0.1:5000";
ChromeOptions options = new ChromeOptions().addArguments("--proxy-server=http://" + proxy);
WebDriver driver = new ChromeDriver(options);
//WebDriver driver = new ChromeDriver();
driver.get("https://www.google.co.in/");

}


}



