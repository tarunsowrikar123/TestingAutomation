package practisePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//get the count of links total in page
		System.out.println(driver.findElements(By.tagName("a")).size());
		//get the count of links in footer section
		System.out.println(driver.findElements(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style a")).size());
		//get the count of links in first column of footer section
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a")).size());
		//click on all the links in first column in footer section to check if it is opening
		//Actions a = new Actions(driver);
		for(int i=0;i<driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a")).size();i++) {
			
			
			//open all links and navigate back and again open link
//			driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a")).get(i).click();
			//driver.navigate().back();
			
			//open all links in seperate tabs using Keys class
			driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
			Thread.sleep(2000);
		}
		
		
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
		
		
	//driver.close();  // it only closes the driver window, but all other tabs will be open	
		
		driver.quit();
	}

}
