package com.maveric.githubstepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maveric.github.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GithubLoginStepDef {

	private WebDriver driver;

	@Before
	public void setUpEnv() {
		driver = DriverFactory.getDriver();

	}

	@Given("User is on the GitHub login page")
	public void user_is_on_the_git_hub_login_page() {
		driver.get("https://github.com/login");

	}

	@When("User enters invalid username {string} and invalid password {string}")
	public void user_enters_invalid_username_and_invalid_password(String string, String string2) {
		driver.findElement(By.id("login_field")).sendKeys("balajipatil");
		driver.findElement(By.id("password")).sendKeys("Satara");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.name("commit")).click();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String string) {
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Incorrect username or password')]"));
		ele.getText();
		System.out.println(ele);
	}

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String string, String string2) {
		driver.findElement(By.id("login_field")).sendKeys("BalajiPatil8087");
		driver.findElement(By.name("password")).sendKeys("Satara@4583");
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		driver.findElement(By.name("commit")).click();
		// WebElement
		// ele1=driver.findElement(By.xpath("//span[normalize-space()='Dashboard'])[2]"));
		// ele1.getText();
		// System.out.println(ele1);
	}

	@After
	public void tearDownEnv() {
		driver.quit();
	}

}
