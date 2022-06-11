package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddBook {

	WebDriver driver;
	
	public  AddBook(WebDriver driver) {
		this.driver=driver;
	}
	
	By addbook=By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/span/div/div[1]/div/a");
	By bookname=By.xpath("//*[@id='nest-messages_book_bookName']");
	By des=By.id("nest-messages_book_description");
	By publication=By.id("nest-messages_book_yearOfPublication");
	By type=By.id("nest-messages_book_bookType");
	By submit=By.xpath("//*[@id=\"nest-messages\"]/div[5]/div/div/div/button/span");
	
	
	public void addbk() {
		driver.findElement(addbook).click();	
	}
	
	public void bookdetails(String bkname,String descrip,String Yrofpublic,String bktype) throws InterruptedException {
		driver.findElement(bookname).sendKeys(bkname);
		driver.findElement(des).sendKeys(descrip);
		driver.findElement(publication).sendKeys(Yrofpublic);
		driver.findElement(type).sendKeys(bktype);
		driver.findElement(submit).click();
		Thread.sleep(5000);
		}
}
