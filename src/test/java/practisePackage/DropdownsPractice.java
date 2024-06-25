package practisePackage;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropdownsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().window().maximize();
		
		
		//Static Dropdowns
		
		//select class is used to access the static dropdowns. 
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByIndex(2);
		
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=0;i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
		//Dynamic Dropdowns
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //if we give directly //a[@value='MAA'], it will search for the element in the first dropdown only so we shd mention which xpath shd it select.
		//to handle this situation of dynamic dropdown we should mention explicitely which xpath it shd select.
		//instead of using indexes we can use parent to child relationship locator
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		Thread.sleep(2000);
		
		
		
		//Auto Suggestive Dropdown --> we will get options as we enter text in the field
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);//as it takes some time to show us options
		//we shd store all the options in a list and iterate it to select the option we need.
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));//this stores all the values in a list
		for(WebElement option : options) {   //this loop navigates through all the values and matches with what we need
			if(option.getText().equals("India")) {
				option.click();
				break;
			}
		}
		
		
		Thread.sleep(2000);
		
		//select radio button
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		
		//handle checkboxes
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		//count number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Thread.sleep(2000);
		
		
		//Select today's date i.e already selected date in calendar
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); //there will be a special class for current date i.e ui-state-highlight
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
