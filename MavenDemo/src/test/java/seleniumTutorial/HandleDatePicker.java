package seleniumTutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		String date = "20";
		String month = "July";
		String year = "2023";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		while(true) {
			String monthyear = driver.findElement(By.xpath
					("//td[@class='monthTitle']")).getText();
			String arr[] = monthyear.split(" ");
			String yr = arr[1];
			String mon = arr[0];
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//button[text()='>']")).click();
			}
		}
		
		//Date Selection
		List<WebElement> alldates = driver.findElements(By.xpath
				("//table[@class='rb-monthTable first last']//td"));
		for(WebElement ele : alldates) {
			if(ele.getText().equals(date)) {
				ele.click();
				break;
			}
		}

	}

}
