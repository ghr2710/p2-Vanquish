package com.revature.voteappboot.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class VoteAppHome {
WebDriver driver;
	
	
	@FindBy(id="username")
	WebElement usernameInput;
	@FindBy(id="password")
	WebElement passwordInput;
	@FindBy(id="submit")
	WebElement logIn;
	WebElement messageBox;
	public VoteAppHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("http://localhost:4200/");
		
	}
	
	public void inputUsername(String username) {
		usernameInput.sendKeys(username);
}
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void submitLogin() {
		logIn.click();
	
	}
	public void logOut() {
		if (logIn.getText().equals("Log Out")) {
			logIn.click();
		}
	}
	public String getMessageBoxText() {
		return messageBox.getText();
	}
	public String getNavText() {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions
				.numberOfElementsToBe(By.id("nameDisplay"), 1));
		
		return driver.findElement(By.id("nameDisplay")).getText();
	}
}
