package practisePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		//Nested Frames --> we have frame inside the frame so first we should switch to main frame then to particular frame
		driver.switchTo().frame(driver.findElement(By.name("frame-top"))).switchTo().frame(driver.findElement(By.name("frame-middle"))); 
	//	driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.close();
	}

}
