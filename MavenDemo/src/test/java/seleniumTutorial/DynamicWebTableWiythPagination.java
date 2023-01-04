package seleniumTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWiythPagination {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		String text=driver.findElement(
				By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int total_pages = Integer.valueOf(
				text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println(total_pages);
		
		for(int p=1;p<=total_pages;p++) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println(active_page.getText());
			//active_page.click();
			
			int rows = driver.findElements(By.xpath
					("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("Number of rows "+rows);
			
			String pageno = Integer.toString(p+1);
			Thread.sleep(3000);
			
			WebElement nextpage =driver.findElement(By.xpath
					("//ul[@class='pagination']//li//a[text()='"+pageno+"']"));
			System.out.println(nextpage.getText());
			nextpage.click();
		}
	}

}
