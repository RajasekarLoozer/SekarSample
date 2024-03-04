package org.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.base.Base;
import org.junit.Ignore;
import org.openqa.selenium.WebElement;
import org.pageobject.PageObject;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions extends Base {
	PageObject pageObject;
	String path = ("F:\\sekar\\Application\\Play Ground\\Facebook\\src\\test\\resources\\Raja.xlsx");
    @Ignore
	@When("Url launch")
	public void url_launch() {
		browser("chrome");
		urlLaunch("https://www.facebook.com/");
		maximize();
		pageObject = new PageObject();

	}

	@Ignore
	@Given("Enter the username and password")
	public void enter_the_username_and_password() throws IOException {
		pageObject = new PageObject();
		String uservalue = excel(path, "date", 1, 0);
		WebElement username = pageObject.getUsername();
		passvalue(username, uservalue);
		String passvalue = excel(path, "date", 1, 1);
		WebElement password = pageObject.getPassword();
		passvalue(password, passvalue);

	}

	@Given("Enter the username and password using 1D without heading")
	public void enter_the_username_and_password_using_1d_without_heading(DataTable dataTable) {
		pageObject = new PageObject();
		List<String> asList = dataTable.asList();
		passvalue(pageObject.getUsername(), asList.get(0));
		passvalue(pageObject.getPassword(), asList.get(1));

	}

	@Given("Enter the username and password using 1D with heading")
	public void enter_the_username_and_password_using_1d_with_heading(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();
		passvalue(pageObject.getUsername(), asMap.get("username1"));
		passvalue(pageObject.getPassword(), asMap.get("password1"));
//		passvalue(pageObject.getUsername(),asMap.get("username2"));
//		passvalue(pageObject.getPassword(), asMap.get("password2"));

	}
	

	@Given("Enter the username and password using 2D without heading")
	public void enter_the_username_and_password_using_2d_without_heading(DataTable dataTable) {
	   List<List<String>> asLists = dataTable.asLists();
	   List<String> list = asLists.get(0);
	   String string = list.get(0);
	   passvalue(pageObject.getUsername(), string);
	   passvalue(pageObject.getPassword(), asLists.get(3).get(0));
	}


	@Given("Enter the username and password using 2D with heading")
	public void enter_the_username_and_password_using_2d_with_heading(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String string = map.get("username1");
		passvalue(pageObject.getUsername(), string);
		passvalue(pageObject.getPassword(), asMaps.get(2).get("password1"));

	}
	
	@When("Url launch using {string}")
	public void url_launch_using(String string) {
		browser(string);
		urlLaunch("https://www.facebook.com/");
		
	  
	}




	
	   
	
	@Given("Enter the {string} and {string} using examples")
	public void enter_the_and_using_examples(String string, String string2,DataTable dataTable) {
		pageObject = new PageObject();
		passvalue(pageObject.getUsername(), string);
		passvalue(pageObject.getPassword(), string2);
	    
	}










	@Ignore
	@Then("Click login button")
	public void click_login_button() {
		WebElement login = pageObject.getLogin();
		login.click();

	}

}
