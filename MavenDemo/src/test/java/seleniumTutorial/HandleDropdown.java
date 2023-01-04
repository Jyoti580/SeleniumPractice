package seleniumTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement dropdown = driver.findElement(By.id("input-country"));
		Select selectDropdown = new Select(dropdown);
		//selectDropdown.selectByVisibleText("Denmark");
		//selectDropdown.selectByIndex(56);
		//selectDropdown.selectByValue("57");
		
		//select a option without using Select class methods
		
		List<WebElement> allOptions = selectDropdown.getOptions();
		
		for(WebElement option: allOptions) {
			if(option.getText().equals("Cuba")) {
				option.click();
				break;
			}
		}
	}
	

}
