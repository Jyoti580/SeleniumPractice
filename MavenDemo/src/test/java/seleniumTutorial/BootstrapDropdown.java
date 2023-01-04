package seleniumTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		WebElement dropdown = driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]"));
		dropdown.click();
		//WebElement dropdown2 = driver.findElement(By.xpath("//a[text()='Select Product']"));
		List<WebElement> productTypes = driver.findElements
				(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println(productTypes.size());
		
		for(WebElement option: productTypes) {
			if(option.getText().equals("Accounts")) {
				option.click();
				System.out.println("Clicked");
				break;
			}
		}
	}

}
