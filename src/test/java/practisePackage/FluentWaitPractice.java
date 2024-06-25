package practisePackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.*;

public class FluentWaitPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
//		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wdw.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='finish']/h4"))));
//		System.out.println("Success");
		
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement ele = (WebElement) wait.until(new Function<WebDriver, WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				else
					return null;
			}
		});
		
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
		driver.close();
	}

}
