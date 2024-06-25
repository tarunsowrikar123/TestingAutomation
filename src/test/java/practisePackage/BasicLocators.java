package practisePackage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicLocators {
	
	public static void main(String[] args) throws InterruptedException {		
		String username = "Rahul";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");//Launching the browser	//chromedriver is essential to open the browser so system should know where the driver location is in our local			
		WebDriver driver = new ChromeDriver(); //webdriver is interface, chrome driver class implements the interface to implement all the methods of interface		
		driver.manage().window().maximize();//maximize the browser		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");//launch the URL in browser			
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1)); //wait for website to respond	
		//Login functionality //Locators		
		driver.findElement(By.id("inputUsername")).sendKeys(username); //ID locator		 
		driver.findElement(By.name("inputPassword")).sendKeys("Hello123");  //Name Locator
		driver.findElement(By.className("signInBtn")).click(); //className locator		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //CSS Selector -> syntax: tagname.classname or tagname#idname or tagname[attribute=value]		
		//for this CSS Selector only we used implicit wait statement as, as soon as we hit login the text doesnt pop up so selenium cant find the locator that fast, so it should wait for some time to find that element		
		driver.findElement(By.linkText("Forgot your password?")).click(); //LinkText Selector -> this will be used for any 'a' tags in HTML							
		Thread.sleep(1000); //1000milliseconds = 1second	//pausing the script for few seconds so that slider moves completely(In the website) after clicking on forgot your password							
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");		
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("rahul@abc.com");				
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210"); //parent to child traversing xpath		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click(); //xpath Selector	//xpath selector -> syntax : //tagname[@sttribute='value']		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());		
		String password = driver.findElement(By.cssSelector("form p")).getText();		
		String [] password_array = password.split(" ");		
		String new_password = password_array[4].substring(1, 19);		
		driver.findElement(By.className("go-to-login-btn")).click();		
		Thread.sleep(1000);		
		driver.findElement(By.id("inputUsername")).sendKeys(username); //ID locator		 
		driver.findElement(By.name("inputPassword")).sendKeys(new_password);  //Name Locator		 
		driver.findElement(By.id("chkboxOne")).click();		
		driver.findElement(By.id("chkboxTwo")).click();		
		driver.findElement(By.xpath("//button[contains(@class,'submit ')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),"You are successfully logged in.");
		if(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText().equals("You are successfully logged in.")) {
			System.out.println("Successfull Login message is correct");
		}
		else {
			System.out.println("success login message is wrong");
		}
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container h2")).getText(),"Hello "+username+",");
		if(driver.findElement(By.cssSelector("div.login-container h2")).getText().equals("Hello "+username+",")) {
			System.out.println("Welcome "+username+" into website");
		}
		else {
			System.out.println("username and name displayed are wrong");
		}
		
		driver.findElement(By.cssSelector("button.logout-btn")).click();
		
		System.out.println("Logged Out Successfully...");
		
		driver.close();//close the window	
		
	}

}


