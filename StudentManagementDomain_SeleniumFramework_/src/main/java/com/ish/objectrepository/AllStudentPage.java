package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllStudentPage {

	@FindBy(id="grade")
	private WebElement gradeDropdown;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchEditTxt;

	@FindBy(xpath = "//div/table/tbody/tr/td/a[@href='#modalviewform']")
	private WebElement StudentNameLink;


	public AllStudentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getGradeDropdown() {
		return gradeDropdown;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getSearchEditTxt() {
		return searchEditTxt;
	}


	public WebElement getStudentNameLink() {
		return StudentNameLink;
	}

	//Business Libraries

}
