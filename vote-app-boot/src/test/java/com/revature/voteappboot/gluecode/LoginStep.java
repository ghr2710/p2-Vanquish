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




public class LogInStep {
	static WebDriver driver;
	
	
	@BeforeAll
	public static void setUp() {
		File file = new File("src/main/resources/chromedriver.exe");
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
	  driver.findElement(By.id("username")).sendKeys("Test");
	    
	}

	@When("the user enters the correct password")
	public void the_user_enters_the_correct_password() {
		driver.findElement(By.id("password")).sendKeys("Test");
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
		System.out.println("incorrectcredentials");
	}

	@When("the user enters the incorrect password")
	public void the_user_enters_the_incorrect_password() {
		driver.findElement(By.id("password")).sendKeys("durfhfhf");
	    
	}
}

