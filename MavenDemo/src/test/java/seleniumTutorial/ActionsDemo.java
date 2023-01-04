package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement button = driver.findElement(By.xpath
				("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);
		action.contextClick(button).perform();
		
		/*double click
		 * action.doubleClick(button).perform();
		 */
		
		driver.get("https://demo.opencart.com/");
		WebElement desktops = driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[text()='Mac (1)']"));
		Actions act = new Actions(driver);
		act.moveToElement(desktops).moveToElement(mac).click().perform();
		
		//KeyBoard Actions
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Actions action2 = new Actions(driver);
		action2.sendKeys(Keys.ENTER);
		
	}

}
