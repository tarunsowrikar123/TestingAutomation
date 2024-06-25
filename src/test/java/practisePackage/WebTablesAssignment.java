package practisePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//table[@name='courses']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,650)");
		System.out.println("Rows : "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
		System.out.println("Columns : "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());
		List<WebElement> rowValues = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		for(WebElement rowvalue : rowValues) {
			System.out.print(rowvalue.getText()+" ");
		}
		driver.close();
	}
}
