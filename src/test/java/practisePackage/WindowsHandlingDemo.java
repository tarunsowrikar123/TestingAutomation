package practisePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		//Opening into a new window or tab we should take the handles of different windows first - then iterate through them to get the child window handle - then switch to that window
		Set<String> windows = driver.getWindowHandles(); // it stores like [parentID, childID]
		Iterator<String> it = windows.iterator(); 
		String parentID = it.next(); //this goes to 0 index of the windows list
		String childID = it.next(); //this goes to 1 index of windows list i.e child window
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String para = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] words = para.split(" ");
		String email = words[4];
		System.out.println("Email : "+email);
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
