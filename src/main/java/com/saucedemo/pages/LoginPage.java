package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	Page page;

// Locator — — — -

	String username = "id=user-name";
	String password = "id=password";
	String clickLogin = "id=login-button";
	String clickHamburger = "id=react-burger-menu-btn";
    String clickLogout = "id=logout_sidebar_link";

// initialize Page using constructor

	public LoginPage(Page page) {
		this.page = page;

	}

	public String verifyTitle() {
		String title = page.title();
		return title;
	}

//Create methods

// Login into the application

	public void loginIntoApplication(String email, String pass) {
		enterUserName(email);
		enterPassword(pass);
		clickLoginButton();
	}

	public void logoutApplication() {
		clickOnHamburger();
		clickOnLogout();
	} // Logout from the application

	public void enterUserName(String email) {
		page.fill(username, email);
	}

	public void enterPassword(String pass) {
		page.fill(password, pass);
	}

	public void clickLoginButton() {
		page.click(clickLogin);
	}

	public void clickOnHamburger() {
		page.click(clickHamburger);

	}

	public void clickOnLogout() {
		page.click(clickLogout);
	}
}
