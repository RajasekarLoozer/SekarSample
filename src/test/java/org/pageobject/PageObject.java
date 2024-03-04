package org.pageobject;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageObject extends Base{
	public PageObject() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement username;
	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(id = "pass")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(name = "login")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}
	
	
	
	

	

}
