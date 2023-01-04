package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttribute {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://admin-demo.nopcommerce.com/");
		WebElement emailInputBox = driver.findElement(By.id("Email"));
		System.out.println(emailInputBox.getText());//This won't work
		System.out.println(emailInputBox.getAttribute("value"));
		emailInputBox.clear();
		emailInputBox.sendKeys("abc123@gmail.com");
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(login.getAttribute("class"));
		System.out.println(login.getText());
	}

}
