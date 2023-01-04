package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Create a border around this element to highlight
		js.executeScript("arguments[0].style.border='3px solid red'", logo);

		//get title of web page
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);
		
		//Click action
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Register']")));
		
		//Generate an alert in the application
		String message = "This is my alert";
		js.executeScript("alert('"+ message +"')");
		driver.switchTo().alert().accept();
		
		//Browser refresh
		js.executeScript("history.go(0)");
		
		//Scroll down the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//scroll up the page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		//Zoom out the page 50%
		js.executeScript("document.body.style.zoom='50%'");

		
		//Uncomment following code and comment others to see flashing an element
		//by changing the background to default and black alternately
		
		/*String color = logo.getCssValue("backgroundColor");
		String color2 = "#000000";
		for (int i = 0; i < 10; i++) {
			js.executeScript("arguments[0].style.backgroundColor='  " + color2 + " ' ", logo);
			Thread.sleep(2000);
			js.executeScript("arguments[0].style.backgroundColor=' " + color + "'", logo);
			Thread.sleep(2000);
		}*/

	}

}
