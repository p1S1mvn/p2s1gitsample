

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameterizationTest {
	WebDriver oBrowser;
	
	//@Test
	public void ebayInchrome()
	{
ExcelRead oExcel = new ExcelRead("C:\\Users\\reybo\\Desktop\\selenium\\ebay.xls","search");
String sValueToSearch = oExcel.getCellData("searchfor",1);
		
		
			//1.Open Chrome Browser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\reybo\\Downloads\\selenium-java-3.4.0\\ChromeDriver.exe");
			oBrowser = new ChromeDriver();
			
			//2.Launch ==> www.ebay.com
			oBrowser.get("http://www.ebay.com/");
			
			//3.Enter "Laptop"in search text box
			//3.a Recognize the text box ==> oBrowser.findelement(By.id("gh-ac"))
			//3.b then Enter value to the text box
			oBrowser.findElement(By.id("gh-ac")).clear();
			oBrowser.findElement(By.id("gh-ac")).sendKeys(sValueToSearch);
			
			//4.Click on "search" button
			oBrowser.findElement(By.id("gh-btn")).click();
			
			//5.Click on "Advanced" button
			oBrowser.findElement(By.linkText("Advanced")).click();
			
		}
		
	
	
	@Test
	public void ebayInChromeDataDrivenScenario()
	{
		ExcelRead oExcel = new ExcelRead("C:\\Users\\reybo\\Desktop\\selenium\\ebay.xls","search");
	//	String sValueToSearch = oExcel.getCellData("searchfor",1);
		
		for(int i=1; i< oExcel.rowCount(); i++)
		{
			//1.Open Chrome Browser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\reybo\\Downloads\\selenium-java-3.4.0\\ChromeDriver.exe");
			oBrowser = new ChromeDriver();
			
			//2.Launch ==> www.ebay.com
			oBrowser.get("http://www.ebay.com/");
			
			//3.Enter "Laptop"in search text box
			//3.a Recognize the text box ==> oBrowser.findelement(By.id("gh-ac"))
			//3.b then Enter value to the text box
			oBrowser.findElement(By.id("gh-ac")).clear();
			oBrowser.findElement(By.id("gh-ac")).sendKeys(oExcel.getCellData("searchfor",i));
			
			//4.Click on "search" button
			oBrowser.findElement(By.id("gh-btn")).click();
			
			//5.Click on "Advanced" button
			oBrowser.findElement(By.linkText("Advanced")).click();
			
		}
	}
			
}		
			
			
			
			
			
			
		
		
	
	


