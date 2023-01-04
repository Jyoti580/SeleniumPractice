package seleniumTutorial;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dropdown {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("dob")).click();
		WebElement selectMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMon = new Select(selectMonth);
		selectMon.selectByVisibleText("Oct");
		
		WebElement selectYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYr = new Select(selectYear);
		selectYr.selectByVisibleText("1990");
		
		String date = "15";
		List<WebElement> alldates = driver.findElements(By.xpath
				("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele: alldates) {
			if(ele.getText().equals(date)) {
				ele.click();
				break;
			}
		}
	}

}
