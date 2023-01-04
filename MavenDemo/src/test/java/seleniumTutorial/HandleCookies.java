package seleniumTutorial;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		
		System.out.println(cookies.size());
		
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName()+ " "+cookie.getValue());
		}
		
		Cookie cookieobj = new Cookie("MyCookie", "123456");
		driver.manage().addCookie(cookieobj);
		
		System.out.println(" ");
		Set<Cookie> cookies2 = driver.manage().getCookies();
		for(Cookie cookie: cookies2) {
			System.out.println(cookie.getName()+ " "+cookie.getValue());
		}
		System.out.println(cookies2.size());
		
	}

}
