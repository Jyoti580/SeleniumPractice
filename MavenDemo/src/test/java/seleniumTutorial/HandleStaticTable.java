package seleniumTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleStaticTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		int rows = driver.findElements
				(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int cols = driver.findElements
				(By.xpath("//table[@id='customers']//th")).size();
		System.out.println(rows-1);
		System.out.println(cols);
		String value = driver.findElement(
				By.xpath("//table[@id='customers']//tr[3]/td[2]")).getText();
		System.out.println(value);
		
		
		
		WebElement table = driver.findElement
				(By.xpath("//table[@id='customers']"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		for(WebElement r:row) {
			List<WebElement> col = r.findElements(By.tagName("td"));
			for(WebElement c: col) {
				System.out.println(c.getText());
			}
		}
	}

}
