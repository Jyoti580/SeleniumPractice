package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebelement {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		WebElement searchStore = driver.findElement(By.id("small-searchterms"));
		System.out.println("Display status: "+searchStore.isDisplayed());
		System.out.println("Enable status: "+searchStore.isEnabled());
		WebElement male = driver.findElement(By.id("gender-male"));
		WebElement female = driver.findElement(By.id("gender-female"));
		male.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		driver.close();
	}
}
