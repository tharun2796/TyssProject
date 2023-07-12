package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declaration
	@FindBy(xpath="//span[.='Teacher']")
	private WebElement teacherLink;

	@FindBy(xpath="//span[.='Exam']")
	private WebElement examLink;
	
	@FindBy(linkText = "Create Exam")
	private WebElement createExamLink;

	@FindBy(xpath="//span[.='Student']")
	private WebElement studentLink;

	@FindBy(partialLinkText = "Add Teacher")
	private WebElement addTeacherLink;

	@FindBy(partialLinkText = "All Teacher")
	private WebElement allTeacherLink;

	@FindBy(partialLinkText = "Add Student")
	private WebElement addStudentLink;

	@FindBy(partialLinkText = "All Student")
	private WebElement allStudentLink;

	@FindBy(xpath="//span[.='Timetable']")
	private WebElement timetableLink;

	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement adminDropdown;

	@FindBy(linkText = "Sign out")
	private WebElement signoutBtn;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}

	//Utilization
	public WebElement getTeacherLink() {
		return teacherLink;
	}

	public WebElement getExamLink() {
		return examLink;
	}

	public WebElement getStudentLink() {
		return studentLink;
	}

	public WebElement getAddTeacherLink() {
		return addTeacherLink;
	}

	public WebElement getCreateExamLink() {
		return createExamLink;
	}

	public WebElement getAllTeacherLink() {
		return allTeacherLink;
	}

	public WebElement getAddStudentLink() {
		return addStudentLink;
	}

	public WebElement getAllStudentLink() {
		return allStudentLink;
	}

	public WebElement getTimetableLink() {
		return timetableLink;
	}

	public WebElement getAdminDropdown() {
		return adminDropdown;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

    //Business Library
	public void logout(WebDriver driver) {
	adminDropdown.click();
	signoutBtn.click();
	}

}