package seleniumTutorial;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileDemo {
	
	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.foundit.in/");
		driver.manage().window().maximize();
		
		//WebElement uploadResume = 
		/*;
		driver.findElement(By.id("file-upload")).sendKeys
		("C:\\Users\\jyotirmayee.sahu\\Documents\\JAVA\\Java SE 8 programming\\1.Java Fundamentals.txt");
		driver.findElement(By.xpath("//div[@class='close-button mqfi-cross']")).click();
		*/
		
		driver.findElement(By.xpath(" //div[normalize-space()='Upload Resume']")).click();
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\jyotirmayee.sahu\\Documents\\JAVA\\Java SE 8 programming\\1.Java Fundamentals.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

}
