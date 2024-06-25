package practisePackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class alertsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String name = "Malan";
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		if(driver.switchTo().alert().getText().contains(name)) {
			System.out.println("It is showing correct name "+name+" in alert pop up");
		}
		else {
			System.out.println("It is showing wrong name in alert pop up");
		}
		
		driver.switchTo().alert().accept();
		
		
		
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss();
		
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
