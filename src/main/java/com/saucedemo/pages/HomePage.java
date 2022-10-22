package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class HomePage {

Page page;

// Locator — — — -

 String productName_1 ="id=item_4_title_link";

//initialize Page using constructor

public HomePage(Page page) {

this.page =page;}

//Method

public String productName() {

String productName = page.textContent(productName_1);

return productName;}}
