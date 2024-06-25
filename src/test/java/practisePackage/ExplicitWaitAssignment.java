package practisePackage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		ExplicitWaitAssignment ewa = new ExplicitWaitAssignment();
		ewa.loginPage(driver);	
		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(5));
		wdw.until(ExpectedConditions.titleContains("ProtoCommerce"));
		System.out.println(driver.getTitle());
		ewa.addAllItemsToCart(driver);		
		ewa.checkOut(driver);
		driver.close();
	}
	
	public void loginPage(WebDriver driver) {
		String str = driver.findElement(By.cssSelector("p[class='text-center text-white']")).getText();
		String[] strArray = str.split(" ");
		String username = strArray[2].trim();
		String password = strArray[6].substring(0,8);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
		dropdown.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();	
	}
	
	public void addAllItemsToCart(WebDriver driver) {
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='card h-100']"));
		for(int i=0;i<items.size();i++) {
			driver.findElements(By.xpath("//button[contains(text(),'Add')]")).get(i).click();
		}
	}
	
	
	public void checkOut(WebDriver driver) {
		driver.findElement(By.partialLinkText("Checkout")).click();
	}
}
