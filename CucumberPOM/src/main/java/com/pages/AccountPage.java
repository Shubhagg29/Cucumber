package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	 private By accountSection= By.cssSelector("ul.myaccount-link-list span");
	
	 
	 public AccountPage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public String getAccountsPageTitle() {
		return driver.getTitle();
	 }
	 
	 public int getAccountSectionCount(){
		 
		 return driver.findElements(accountSection).size();
		 
	 }
	 
	 public List<String> getAccountsectionList() {
		 
	List <String>accountList= new ArrayList<String>(); 
	List<WebElement> accountheaderList =driver.findElements(accountSection);
	
	  for(WebElement e:accountheaderList) {
		String text=  e.getText();
		accountList.add(text);
		  
	  }
	return accountList;
		 
		 
	 }
	 

}
