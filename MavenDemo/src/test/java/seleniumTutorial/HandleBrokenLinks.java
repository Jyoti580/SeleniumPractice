package seleniumTutorial;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLinks = 0;
		for(WebElement element: links) {
			String url = element.getAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			URL link=new URL(url);
			HttpURLConnection connection = (HttpURLConnection) link.openConnection();
			connection.connect();
			if(connection.getResponseCode()>=400) {
				System.out.println(url+" with response code"+
						connection.getResponseCode()+" is a broken link");
				brokenLinks++;
			}
			else {
				System.out.println(url+" with response code"+
						connection.getResponseCode()+" is a valid link");
			}
		}
		System.out.println("Number of broken links: "+brokenLinks);
		
	}

}
