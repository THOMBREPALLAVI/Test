package Mini_Project;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Project {
	static WebDriver driver;
    
  static ArrayList<String> ar=new ArrayList<String>();
  static void excelFile() 
	{
		
		try{
			//An excel file name you can create a file name with a path information
        File file = new File("C:\\Users\\Sai\\Desktop\\workplace\\MiniProjectTQ\\Excel\\TextData1.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workbook=new HSSFWorkbook(inputStream); //excel workbook from the file system
        HSSFSheet sheet=workbook.getSheet("Laptops");  //1st sheet on the workbook
        
        
        Iterator<Row> itr = sheet.iterator(); //Printed the content of the excel to the console.

        // Iterating over Excel file in Java
        while (itr.hasNext()) {
            Row row = itr.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                
                switch (cell.getCellType()) {
                case STRING:
                    
                    String get = cell.getStringCellValue();
                    ar.add(get);
                    break;
                    
                default:

                
                }
            }
                      
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
		
		System.out.println(ar);
		{
		  System.out.println("****************************************************************");

		}
		
	}
  
  
	
    static void login() throws IOException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sai\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");  
		 driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Login Code
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
	
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7387693113");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("technology");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
		
        for(int i=0;i<ar.size();i++)
       { 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(ar.get(i));
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		List<WebElement> results=driver.findElements(By.xpath("//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom']"));
		
		 
		List<WebElement> links;
		
		System.out.println("\n"+ar.get(i)+"- \n"); //printed item to the console.
		
		int counter=0;
		File file=new File("C:\\Users\\Sai\\Desktop\\data.txt");//text file
		FileWriter f1=new FileWriter(file,true);
		BufferedWriter wr = new BufferedWriter(f1);
		wr.newLine();
		wr.append("\n "+ar.get(i)+"- \n");
		for(WebElement element:results)
		{
			links=element.findElements(By.tagName("a"));
			 
			for(int j=0;j<links.size();j++)
			{
				if(links.get(j).getText().length()>20)
				{
					counter++;
				 
					System.out.println("result "+counter+"-"+links.get(j).getText());
					
					
					wr.append("result "+counter+"-"+links.get(j).getText()+"\n");	
					
					//wr.newLine();
					
				}
				if(counter>=5)
				break;
			}
			
		}
		wr.close();
	
  }	
  
    	
    }
	public static void main(String[] args) throws IOException {
		
		
		excelFile();
		login();
		
		
		
	}

}