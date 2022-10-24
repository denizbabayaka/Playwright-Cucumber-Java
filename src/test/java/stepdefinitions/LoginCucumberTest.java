package stepdefinitions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginCucumberTest {

	LoginPage login;
	HomePage home;
	
	//we have to start playwright server create method will return implementation of playwright
	Playwright playwright = Playwright.create();
	
	//This will give you the option which browser you would launch 
	//Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserType firefox = playwright.firefox();
	Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	
	
	/*
	 * BeforeStep and AfterStep is different then Before and After it will  executes before and after of 
	 * every step of the feature file 
	 */
	@BeforeStep
	public void beforeSteps() {
	System.out.println(" I am inside beforeSteps ----");
	}

	@AfterStep
	public void afterSteps() {

	System.out.println(" I am inside asfterSteps ====");
	}

	 

	 
	

	
	@Given("User launched SwagLabs application")
	public void setUp() {
	page.navigate("https://www.saucedemo.com/");
	home = new HomePage(page);
	login = new LoginPage(page);
	
	}
	
	@When("User verify the Page title")
	public void verifyPageTitle() {
	String title = login.verifyTitle();
	Assert.assertEquals(title, "Swag Labs");
	
	}
	
	
	//Login into the application
	@When("User logged in the app using username {string} and password {string}")
	public void loginIntoTheApplication(String username,String password ) {
	login.loginIntoApplication(username, password);
	}
	
	
	//Verify product name after login
	@Then("User verify the product name {string}")
	public void verifyProductsName(String productname) {
	String productName = home.productName();
	Assert.assertEquals(productName, productname);

	}
	
	//Logout from application
	@Then("User logout from the application")
	public void logoutFromApplication() {
	login.logoutApplication();}
	}
	
	
	
//
//io.cucumber.junit.UndefinedStepException: The step "User logged in the app using username “standard_user” and password “secret_sauce”" is undefined. You can implement it using the snippet(s) below:
//
//@When("User logged in the app using username “standard_user” and password “secret_sauce”")
//public void user_logged_in_the_app_using_username_standard_user_and_password_secret_sauce() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//
//Some other steps were also undefined:
//
//@Then("User verify the product name “Sauce Labs Backpack”")
//public void user_verify_the_product_name_sauce_labs_backpack() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
