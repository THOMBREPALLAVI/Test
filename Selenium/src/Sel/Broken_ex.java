package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

// https://www.toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/

public class Broken_ex {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //To launch softwaretestingmaterial.com
        driver.get("https://www.softwaretestingmaterial.com");
        List<WebElement> links = driver.findElements(By.tagName("a")); 
        //To print the total number of links
        
        System.out.println("Total links are "+links.size()); 
        //used for loop to 
        for(int i=0; i<links.size(); i++) {
        WebElement element = links.get(i);
        
        //By using "href" attribute, we could get the url of the requried link
        String url=element.getAttribute("href");
        
        //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
        //See the detailed functionality of the verifyLink(url) method below
        verifyLink(url); 
        } 
        }
        
        // The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
        public static void verifyLink(String urlLink) {
               try {
        //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
        URL link = new URL(urlLink);
        // Create a connection using URL object (i.e., link)
        HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
        //Set the timeout for 2 seconds
        httpConn.setConnectTimeout(2000);
        //connect using connect method
        httpConn.connect();
        //use getResponseCode() to get the response code. 
        if(httpConn.getResponseCode()== 200) { 
        System.out.println(urlLink+" - "+httpConn.getResponseMessage());
        }
        if(httpConn.getResponseCode()== 404) {
        System.out.println(urlLink+" - "+httpConn.getResponseMessage());
        }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
        catch (Exception e) {
        	//System.out.println("Exception in url "+linkUrl);

        //e.printStackTrace();
        }
           } 
       }