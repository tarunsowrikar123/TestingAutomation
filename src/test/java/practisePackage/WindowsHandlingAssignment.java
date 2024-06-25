package practisePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlingAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);  //switching to second window 
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentID);  // switching back to parent window or first window
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.close();
	}

}
