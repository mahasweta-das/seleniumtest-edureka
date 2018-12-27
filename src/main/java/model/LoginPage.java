package model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase {
@FindBy(xpath="//input[@name='login']") WebElement username;
@FindBy(xpath="//input[@name='login']") WebElement password;
@FindBy(xpath="//input[value='Submit']") WebElement submit;
@FindBy(xpath="//div[contains(text()='Login Failed!')]") WebElement textMessage;

//Initialize all elements of Login Page based on xpath
public LoginPage(){ 
	PageFactory.initElements(driver, this);
}
//Verify Login Page Title
public String validateLoginPageTitle(){
	return driver.getTitle();
}
//Login
public boolean login(String uname,String passwrd){			
	//provide username/password
	username.sendKeys(uname);
	password.sendKeys(passwrd);
	
	//click on submit button
	submit.submit();
	
	//Verify login is successful > As edureka password is not working edureka/edureka
	return textMessage.isDisplayed();		
}	
}
