package practisePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Actions a = new Actions(driver);
		//for all actions we needs to build() and perform() the action
		//moves to specific element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		//move to textbox,click on textbox, keydown the shift(to enter as capitals) and enter the text in capitals
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//remove the text from textbox, we will select the text using double click the text and press backspace
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
		
		//select the text in textbox, usually we will double click in text box to select
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("prac").doubleClick().build().perform();
		
		//right click on element
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();
		
		//driver.close();
	}

}
