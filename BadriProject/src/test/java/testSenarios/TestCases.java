package testSenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AddBook;

public class TestCases {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void befortest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://react-restapi-5a849.web.app/home");
	}
	
	@Test(priority = 0)
	public void createbook() throws InterruptedException {
		AddBook page=new AddBook(driver);
		page.addbk();
		page.bookdetails("Badri","Legend", "1998", "Herotic");
	}
	
	@AfterTest
	private void aftertest() {
		driver.quit();
	}
}
