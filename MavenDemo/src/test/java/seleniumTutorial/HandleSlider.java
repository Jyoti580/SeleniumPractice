package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSlider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement minSlider = driver
				.findElement(By.xpath("//div[@class='ui-slider-range ui-corner-all ui-widget-header']"));
		System.out.println(minSlider.getLocation());
		System.out.println(minSlider.getSize());

		Actions act = new Actions(driver);
		act.dragAndDropBy(minSlider, 40, 0).perform();

		System.out.println(minSlider.getLocation());

		WebElement maxSlider = driver
				.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]"));
		System.out.println(maxSlider.getLocation());
		act.dragAndDropBy(maxSlider, -50, 0).perform();
		System.out.println(maxSlider.getLocation());

	}

}
