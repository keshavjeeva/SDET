package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.hooks;

public class stepDefinition {

WebDriver driver = hooks.driver;
	
	
	@Given("^User launches a browser and navigate to elearning URL$")
	public void user_launches_a_browser()  {

		
		//WebDriver driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\eclipse\\supportFiles\\BrowserDrivers\\geckodriver.exe"); WebDriver
		 * driver = new FirefoxDriver(); driver.get("https://www.google.com");
		 */
	}
	

	@When("^User click signup$")
	public void user_click_signup()  {
		driver.findElement(By.partialLinkText("Sign up")).click();

	}
	
	@When("^User enter all Mandatory information$")
	public void user_enter_all_Mandatory_information()  {
		driver.findElement(By.xpath("//p[contains(text(),'Follow courses')]")).click();
		driver.findElement(By.xpath("//input[@id='registration_firstname']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@id='registration_lastname']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys("1144@gmail.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("1144");
		driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys("12345678");
				
	}

	@When("^User enter valid \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_valid_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)  {
		driver.findElement(By.xpath("//p[contains(text(),'Follow courses')]")).click();
		driver.findElement(By.xpath("//input[@id='registration_firstname']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@id='registration_lastname']")).sendKeys(arg2);
		driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys(arg4);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(arg3);
		driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys(arg5);
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys(arg6);
	}
	
	@When("^User click register$")
	public void user_click_register()  {
	    driver.findElement(By.xpath("//button[@id='registration_submit']")).click();
	}

	@When("^User see successful registration message$")
	public void user_see_successful_registration_message()  {
	  driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']")).isDisplayed();
	  
	}
	@When("^User clicks homepage from successful registration page$")
	public void user_clicks_homepage_from_successful_registration_page()  {
	   driver.findElement(By.partialLinkText("Homepage")).click();
	}

	@When("^User clicks on profile dropdown$")
	public void user_clicks_on_profile_dropdown()  {
	   driver.findElement(By.xpath("//span[@class='caret']")).click();
	}
	
	@When("^User clicks on Message$")
	public void user_clicks_on_Message()  {
	    driver.findElement(By.partialLinkText("Inbox")).click();
	    
	}
	
	@Then("^User logout and close the browser$")
	public void user_logout_and_close_the_browser()  {
		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.id("logout_button")).click();
		driver.quit();
	}
	
	@When("^User enters mandatory information in compose message$")
	public void user_enters_mandatory_information_in_compose_message() throws InterruptedException  {
		
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("123");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[contains(text(),'VS')]")).click();
		
		//WebElement dropdown = driver.findElement(By.xpath("//ul[@id='select2-compose_message_users-results']"));
		//Select s = new Select(dropdown);
		//driver.s.selectByVisibleText("victor sam (VS)");
		
		
		/*
		 * List<WebElement> dropdown = driver.findElements(By.xpath(
		 * "//ul[@id='select2-compose_message_users-results']"));
		 * 
		 * for(int i = 0 ;i< dropdown.size();i++) {
		 * 
		 * if(( dropdown.get(i)).getText().equals("victor sam (VS)")) {
		 * dropdown.get(i).click(); break; } }
		 */ 
		
		
		/*
		 * Actions act = new Actions(driver);
		 * act.sendKeys(Keys.DOWN);
		 * act.sendKeys(Keys.ENTER);
		 */
		
		
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys("TEST MESSAGE");
		
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitForElementToBeLoad("//body");
		 driver.findElement(By.xpath("//body")).click();
		 waitForElementToBeLoad("//body");
		driver.findElement(By.xpath("//body/p")).sendKeys("test email");
		driver.switchTo().defaultContent();
		
		
	}



	private void waitForElementToBeLoad(String string) {
		// TODO Auto-generated method stub
		
	}


	@When("^User click send message$")
	public void user_click_send_message()  {
		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
	}

	@Then("^User see success message$")
	public void user_see_success_message()  {
	    driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	}

	
}
