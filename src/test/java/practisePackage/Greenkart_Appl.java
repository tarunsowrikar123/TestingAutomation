package practisePackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Greenkart_Appl {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);		
		String [] productNames = {"Cucumber","Brocolli", "Tomato"};		
		Greenkart_Appl ga = new Greenkart_Appl();
		ga.addItems(driver, productNames);
		ga.proceedToCheckOut(driver);
		driver.close();	
	}
	
	
	public void addItems(WebDriver driver, String[] productNames) {
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> productNamesList = Arrays.asList(productNames);
		int i=0,j=0;
		for(WebElement item : items) {
			String productNameUI = item.getText();
			String[] formattedNameUI = productNameUI.split("-");
			String formattedName = formattedNameUI[0].trim();
			if(productNamesList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			i++;
			if(j==productNames.length) {
				break;
			}
		}	
	}
	
	public void proceedToCheckOut(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy"); //this needs implicit wait to load the webpage
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(5)); //Explicit wait
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //these 2 lines are constant syntax for explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); //even this needs wait but implicit wait only waits for 2seconds so we need to add explicit wait for this as this needs more time
	}
	
}
