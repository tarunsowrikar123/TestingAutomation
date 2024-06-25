package practisePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,500)");
		List<WebElement> prices = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0 ;
		for(WebElement price : prices) {
			sum += Integer.parseInt(price.getText());
		}
		System.out.println(sum);
		
		int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(totalAmount);
		
		Assert.assertEquals(sum, totalAmount);
		
		driver.close();
	}

}
