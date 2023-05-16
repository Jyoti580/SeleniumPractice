package seleniumTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println(checkboxes.size());
		/*for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}*/
		for (WebElement checkbox : checkboxes) {
			if (checkbox.getAttribute("id").equals("sunday")) {
				checkbox.click();
			}
		}
	}

}
