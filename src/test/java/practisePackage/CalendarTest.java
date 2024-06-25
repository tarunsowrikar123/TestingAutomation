package practisePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String month = "6";
		String date = "15";
		String year = "2027";
		String[] expecteddate= {month,date,year};
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[contains(text(),'"+year+"')]")).click();
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day']/abbr[text()='"+date+"']")).click();
		List<WebElement> actualdate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<actualdate.size();i++) {
			System.out.println(actualdate.get(i).getAttribute("value"));
			Assert.assertEquals(actualdate.get(i).getAttribute("value"),expecteddate[i]);	
			}
		driver.close();
	}

}
