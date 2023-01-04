package seleniumTutorial;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		String parentId = it.next();
		String childId = it.next();
		System.out.println(parentId);
		System.out.println(childId);
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
//		for(String winid : windowIDs) {
//			System.out.println(driver.switchTo().window(winid).getTitle());
//		}
	}

}
