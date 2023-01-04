package seleniumTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println();
		System.out.println(driver.getPageSource());
		driver.close();
	}

}
