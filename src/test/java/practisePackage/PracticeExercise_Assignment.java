package practisePackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeExercise_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String label = null;
		List<WebElement> values = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		int i=0;
		for(WebElement value : values) {
			if(value.isSelected()) {
				label = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label")).get(i).getText();
			}
			i++;
		}
		System.out.println(label);
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(label);
		driver.findElement(By.id("name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		String alertmsg = driver.switchTo().alert().getText();
		if(alertmsg.contains(label)) {
			System.out.println("Alert message contains the option selected in checkbox "+label);
		}
		else
			System.out.println("Alert message doesn't contain "+label);
		driver.switchTo().alert().accept();
		driver.close();
		
	}

}
