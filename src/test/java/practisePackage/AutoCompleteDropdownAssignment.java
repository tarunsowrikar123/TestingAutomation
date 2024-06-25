package practisePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(2000);
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		System.out.println(countries.size());
		String countryName = "United Kingdom";
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getText().contains(countryName)) {
				countries.get(i).click();
			}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		driver.close();
	}

}
