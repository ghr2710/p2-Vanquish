package com.revature.voteappboot.gluecode;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginStep {
	static WebDriver driver;
	
	
	@BeforeAll
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		
	}
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
	    driver.navigate().to("http://localhost:4200/");
	    
	}

	@When("the user enters the correct username")
	public void the_user_enters_the_correct_username() {
	  driver.findElement(By.id("username")).sendKeys("test");
	    
	}

	@When("the user enters the correct password")
	public void the_user_enters_the_correct_password() {
		driver.findElement(By.id("password")).sendKeys("test");
	}
	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		driver.findElement(By.id("submit")).click();
	    
	}

	@Then("a message box will display welcoming the user")
	public void a_message_box_will_display_welcoming_the_user() {
	    
		driver.findElement(By.id("submit")).click();
	}

	@When("the user enters an incorrect username")
	public void the_user_enters_an_incorrect_username() {
		driver.findElement(By.id("username")).sendKeys("fhffnfhfh");
	}

	@Then("an incorrect credentials message will be displayed")
	public void an_incorrect_credentials_message_will_be_displayed() {
		driver.switchTo().alert().accept();
	}

	@When("the user enters the incorrect password")
	public void the_user_enters_the_incorrect_password() {
		driver.findElement(By.id("password")).sendKeys("durfhfhf");
	}
		@When("the user enters a username and password")
		public void the_user_enters_a_username_and_password() {
			driver.findElement(By.id("username1")).sendKeys("sunny");
			driver.findElement(By.id("password1")).sendKeys("sunny");
			driver.findElement(By.id("password2")).sendKeys("sunny");
			
			
}

		@Then("a message box will display stating that a user was successfully created")
		public void a_message_box_will_display_stating_that_a_user_was_successfully_created() {
			driver.findElement(By.id("submit2")).click();
			driver.findElement(By.id("passMessage")).getText();
		}

		@When("the user enters a username that is already taken")
		public void the_user_enters_a_username_that_is_already_taken() {
			driver.findElement(By.id("username1")).sendKeys("test");
		}

		@Then("a message box will display stating that the username is taken")
		public void a_message_box_will_display_stating_that_the_username_is_taken() {
			driver.findElement(By.id("submit2")).click();
			driver.findElement(By.id("passMessage")).getText();
		}


	}


