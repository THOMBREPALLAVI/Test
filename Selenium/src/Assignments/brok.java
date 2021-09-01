package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

// https://www.toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/

public class brok {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");

        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link : links)
        {
        	String url = link.getAttribute("href");
        	System.out.println("url");
        	if(url==null || url.isEmpty())
        	{
        		System.out.println("url is empty");
        		continue;
        	}
        	try {
        	HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
        	huc.connect();
        	if(huc.getResponseCode()>=400) {
        		System.out.println(url="is broken");
        		
        	}
        	else {
        		System.out.println(url="is valid");
        		
        	}
        	}
        	catch (Exception e) {
        		e.printStackTrace();
        	}
        	driver.close();
        	
        }
    }
}
        