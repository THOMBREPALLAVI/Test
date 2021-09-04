package project;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mini_Project {
	
	static WebDriver driver;
	static void xlReader() {

    //public Sheet XlReader() throws IOException {
		// TODO Auto-generated method stub
		
    	try {
		 
		File file=new File("C:\\Users\\Sai\\Desktop\\workplace\\Mini\\Excel\\TextData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
		String data1=sheet1.getRow(1).getCell(0).getStringCellValue();
		String data2=sheet1.getRow(2).getCell(0).getStringCellValue();
		System.out.println(data0);
		System.out.println(data1);
		System.out.println(data2);
		
		//Search(data0,data1,data2);
		wb.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	//return sheet1;
    }

   /*public static void main(String[] args) {
    	xlReader();
    	//System.out.println("Laptops");
		
		}
*/
    
    static void Search(String data0,String data1,String data2) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        
        //Sign In 
        driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7387693113");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	    driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("technology");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		//Product Search
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);
		
		List<WebElement> results=driver.findElements(By.xpath("//div[@class=\"s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom\"]");
		List<WebElement> links;
		int size;
		for(WebElement element:results)
		{
			links=element.findElements(By.tagName("a"));
			size=links.size();
			for(int i=0;i<size;i++)
			{
				if(links.get(i).getText().length()>20)
				{
					for(i=2;i<=4;i++)
					{
						System.out.println("No."+i);
						System.out.println(links.get(i).getText());
					}
				
				
			}
		}
    }
}
public static void main(String[] args) {
	xlReader();
				


    }

}
