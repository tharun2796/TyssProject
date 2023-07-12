package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllTeacherPage {

	//Declaration
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchEdtTxt;

	@FindBy(xpath="//thead/following-sibling::tbody/tr[1]/td/a[@href='#modalViewform']")
	private WebElement teacherNameTxt;

	//Initialization
	public AllTeacherPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getSearchEdtTxt() {
		return searchEdtTxt;
	}

	public WebElement getTeacherNameTxt() {
		return teacherNameTxt;
	}

	
	
}

