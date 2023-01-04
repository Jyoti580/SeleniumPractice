package seleniumTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementVsFindElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		// findElement returns first matching element for a
		// Multiple webelements object
		WebElement searchStore = driver.findElement(By.id("small-searchterms"));
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footer.getText());
//		WebElement noSuchElement =
//				driver.findElement(By.xpath("nosuchElement"));
		
		List<WebElement> searchStore2 = driver.findElements(By.id("small-searchterms"));
		System.out.println(searchStore2.size());
		List<WebElement> footer2 = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footer.getText());
		System.out.println(footer2.size());
		for(WebElement el : footer2) {
			System.out.println(el.getText());
		}
		List<WebElement> noSuchElement2 =
				driver.findElements(By.xpath("nosuchElement"));
		System.out.println(noSuchElement2.size());

	}

}
