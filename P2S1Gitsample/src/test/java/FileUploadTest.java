

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {
	
	@Test
	public void example() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reybo\\Downloads\\selenium-java-3.4.0\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();
		
		//just updates
		System.out.println("hi");
		oBrowser.get("http://www.zamzar.com/");
		oBrowser.manage().window().maximize();
		
		oBrowser.findElement(By.id("inputfile")).click();
		
		String sFilePath = "C:\\Users\\reybo\\Desktop\\selenium\\Tara";
		
		//selecting the string (path of the file
		StringSelection oFilePathToBeUpload = new StringSelection(sFilePath);
		
		//copying the path into clipboard => ctrl+c
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(oFilePathToBeUpload,null);
		
		//Goto the place where we want to paste - cursor focus
		Robot oRbt = new Robot();
		oRbt.keyPress(KeyEvent.VK_ENTER);
		oRbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		//ctrl+v ==> pasting path from clipboard
		oRbt.keyPress(KeyEvent.VK_V);
		oRbt.keyRelease(KeyEvent.VK_ENTER);
		oRbt.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		
		oRbt.keyPress(KeyEvent.VK_ENTER);
		oRbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
		
		
		
	}

}
