package browser;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	
	WebDriver driver = new ChromeDriver();
	ChromeOptions options = new ChromeOptions();
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	
	
	
	
}
