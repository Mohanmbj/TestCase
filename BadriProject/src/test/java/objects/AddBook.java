package objects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	By booklist=By.xpath("//*[@class='ant-table-cell']/a");
	By back=By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/span/div/div[2]/div/a");
	
	

	
	
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
	
	public void booklist(String bkname,String descrip,String Yrofpublic,String bktype) throws InterruptedException {
		driver.findElement(back).click();
		Thread.sleep(6000);
			List<WebElement> bklist=driver.findElements(booklist);
			int size=bklist.size();
			String xp="//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr["+size+"]/td";
			By newdetails=By.xpath(xp);
			List<WebElement> newbklist=driver.findElements(newdetails);
			for (int i = 0; i < 4; i++) {
				System.out.println(newbklist.get(i).getText());
			}
			assertEquals(newbklist.get(0).getText(), bkname);
			assertEquals(newbklist.get(1).getText(), descrip);
			assertEquals(newbklist.get(2).getText(), Yrofpublic);
			assertEquals(newbklist.get(3).getText(), bktype);		
	}
	
	
}
