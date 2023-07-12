package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateExamPage {
	
	// Declaration
	@FindBy(partialLinkText = "Add")
	private WebElement addBtn;

	@FindBy(id = "name")
	private WebElement examNameEdtTxt;

	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchEditTxt;
	
	@FindBy(xpath= "//div/table/tbody/tr/td[2]")
	private WebElement fetchExamName;

	//Initialization
	public CreateExamPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getExamNameEdtTxt() {
		return examNameEdtTxt;
	}	

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSearchEditTxt() {
		return searchEditTxt;
	}

	public WebElement getFetchExamName() {
		return fetchExamName;
	}
	
	//Business Libraries
	public void createExam(String examName) {
	addBtn.click();
	examNameEdtTxt.sendKeys(examName);
	submitBtn.click();
	}
}
