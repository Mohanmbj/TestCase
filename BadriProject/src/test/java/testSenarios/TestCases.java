package testSenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AddBook;
import objects.BasicFunctions;
import objects.EditBook;

public class TestCases {
	
	WebDriver driver;
	AddBook page;
	EditBook pg;
	BasicFunctions bf;
	
	
	@BeforeTest
	public void befortest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://react-restapi-5a849.web.app/home");
	}
	
	
	@Test(priority = 0,enabled = true)
	public void createbook() throws InterruptedException {
		page=new AddBook(driver);
		page.addbk();
		page.bookdetails("sultan","Playboy", "1099", "Romeo");
	}
	
	@Test(priority = 1,enabled = true)
	public void bookdeatils() throws InterruptedException{
		page=new AddBook(driver);
		page.booklist("sultan","Playboy", "1099", "Romeo");
	}
	
	@Test(priority = 2,enabled = true)
	public void updatebookdetails() throws InterruptedException {
		pg=new EditBook(driver);
		pg.editbkdetails("Maths");
		pg.updatedbooklist("Maths","good book 1", "2012", "Romance, Thriller");
	}
	
	@Test(priority = 3enabled = true)
	public void backoption() {
		bf=new BasicFunctions(driver);
		bf.back();
		}
	
	@Test(priority = 4)
	public void bookdel() {
		bf=new BasicFunctions(driver);
		bf.deletebook();
	}
	
	@AfterTest
	private void aftertest() {
		driver.quit();
	}
}
