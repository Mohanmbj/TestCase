package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicFunctions {

	WebDriver driver;
	
	 public BasicFunctions(WebDriver driver) {
		this.driver=driver;
	}
	 
	//back
	 By bookname=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/a");
	 By back=By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/span/div/div[2]/div/a");
	 
	 //delete
	 By delete=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/div/div[2]/a");
	 
	
	 public void back() {
		driver.findElement(bookname).click();
		driver.findElement(back).click();
	}
	 
	 public void deletebook() {
		 driver.findElement(delete).click();
	 }
	 
}
