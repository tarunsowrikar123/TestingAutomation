package practisePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {
	public static void main(String [] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame"))); //used to switch to the frame using webelement
		Actions a = new Actions(driver); //to achieve the drag and drop functionality from actions class 
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();//to switch back to normal web page from the frame
	}
	
}
