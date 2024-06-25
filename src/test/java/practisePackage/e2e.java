package practisePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.linkText("Chennai (MAA)")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is one side trip");
		}
		else {
			System.out.println("It is round trip");
		}
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=0;i<3;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> countries = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getText().equalsIgnoreCase("india")) {
				countries.get(i).click();
				break;
			}
		}
		
		
		Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByIndex(1);
		
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		Thread.sleep(2000);
		driver.close();

	}

}
