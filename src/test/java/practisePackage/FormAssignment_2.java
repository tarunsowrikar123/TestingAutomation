package practisePackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAssignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Ashok");
		driver.findElement(By.name("email")).sendKeys("ashok@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("ashok123");
		driver.findElement(By.id("exampleCheck1")).click();
		Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		gender.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("11-02-1998");
		driver.findElement(By.className("btn-success")).click();
		System.out.print(driver.findElement(By.className("alert-success")).getText().substring(1));
		driver.close();
	}

}
