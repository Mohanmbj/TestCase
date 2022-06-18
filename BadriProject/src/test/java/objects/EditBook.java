package objects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditBook {

	WebDriver driver;
	
	 public EditBook(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By edit=By.xpath("//*[@class='ant-space-item']/a");
	By bookname=By.id("nest-messages_bookName");
	By submit=By.xpath("//button[@type='submit']");
	
	By booklist=By.xpath("//*[@class='ant-table-cell']/a");
	By back=By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/span/div/div[2]/div/a");
	
	
	public void editbkdetails(String newyr) throws InterruptedException {
		driver.findElement(edit).click();
		WebElement newtxt=driver.findElement(bookname);
		newtxt.clear();
		Thread.sleep(2000);
		newtxt.sendKeys(newyr);
		driver.findElement(submit).click();
		Thread.sleep(5000);
	}
	
	public void updatedbooklist(String bkname,String descrip,String Yrofpublic,String bktype) throws InterruptedException {
		driver.findElement(back).click();
		Thread.sleep(6000);
			List<WebElement> bklist=driver.findElements(booklist);
			int size=bklist.size();
			System.out.println(size);
			String xp="//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td";
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
