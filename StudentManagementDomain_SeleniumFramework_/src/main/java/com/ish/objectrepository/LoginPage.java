package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration
	@FindBy(id="email")
	private WebElement usernameEdtTxt;

	@FindAll({@FindBy(id="password"),@FindBy(name="password")})
	private WebElement passwordEdtTxt;

	@FindBy(id="btnSubmit")
	private WebElement submitBtnClk;

	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getUsernameEdtTxt() {
		return usernameEdtTxt;
	}

	public WebElement getPasswordEdtTxt() {
		return passwordEdtTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtnClk;
	}	

	//Business Libraries
	public void loginToApp(String username,String password) {
		usernameEdtTxt.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		submitBtnClk.click();
	}
}