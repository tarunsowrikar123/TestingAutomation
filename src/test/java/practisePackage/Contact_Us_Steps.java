package practisePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contact_Us_Steps {

	WebDriver driver = new ChromeDriver();
	
	@Given("User accesses the webdriver university successfully.")
	public void user_accesses_the_webdriver_university_successfully() {	
		driver.manage().window().maximize();
		driver.get("https://webdriveruniversity.com/");
		driver.findElement(By.id("contact-us")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
	}

	@When("Enter the First Name")
	public void enter_the_first_name() {
		driver.findElement(By.name("first_name")).sendKeys("Tarun");
	}

	@And("Enter the last name")
	public void enter_the_last_name() {
		driver.findElement(By.name("last_name")).sendKeys("Khan");
	}

	@And("Enter the email")
	public void enter_the_email() {
	 driver.findElement(By.name("email")).sendKeys("khan@abc.com");
	}

	@And("Enter the comments")
	public void enter_the_comments() {
		driver.findElement(By.name("message")).sendKeys("ABC EFG");
	}

	@And("Hit the Submit button")
	public void hit_the_submit_button() {
	  driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
	}

	@Then("Validate the success message in the page.")
	public void validate_the_success_message_in_the_page() {
		System.out.println(driver.findElement(By.xpath("//div[@id='contact_reply']/h1")).getText());
		driver.quit();
	}
}
