package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ish.genericutility.WebActionUtility;

public class CreateTimetablePage {
	//Declaration
	@FindBy(id="grade")
	private WebElement gradeDropdown;

	@FindBy(xpath="//button[.='Submit']")
	private WebElement gradeSubmitBtn;

	@FindBy(partialLinkText = "Add")
	private WebElement addBtn;

	@FindBy(id="day")
	private WebElement dayDropdown;

	@FindBy(id="subject")
	private WebElement subjectDropdown;

	@FindBy(id="teacher")
	private WebElement teacherDropdown;

	@FindBy(id="classroom")
	private WebElement clsroomDropdown;

	@FindBy(id="start_time")
	private WebElement startTimeEdtTxt;

	@FindBy(id="end_time")
	private WebElement endTimeEdtTxt;

	@FindBy(id="btnSubmit")
	private WebElement subjectRoutingSubmitBtn;

	//Initialization
	public CreateTimetablePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getGradeDropdown() {
		return gradeDropdown;
	}

	public WebElement getgradeSubmitBtn() {
		return gradeSubmitBtn;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getDayDropdown() {
		return dayDropdown;
	}

	public WebElement getSubjectDropdown() {
		return subjectDropdown;
	}

	public WebElement getTeacherDropdown() {
		return teacherDropdown;
	}

	public WebElement getClsroomDropdown() {
		return clsroomDropdown;
	}

	public WebElement getStartTimeEdtTxt() {
		return startTimeEdtTxt;
	}

	public WebElement getEndTimeEdtTxt() {
		return endTimeEdtTxt;
	}

	public WebElement getsubjectRoutingSubmitBtn() {
		return subjectRoutingSubmitBtn;
	}

	//Business Libraries
	public void selectGrade(WebDriver driver,String grade) {
		CreateTimetablePage ctp = new CreateTimetablePage(driver);
		WebActionUtility wLib = new WebActionUtility();
		wLib.selectByText(gradeDropdown, grade);
		ctp.gradeSubmitBtn.click();
	}

	public void addSubjectRouting(WebDriver driver, String day,String subject,String teacher,String classroom,String startTime,String endTime) {
		CreateTimetablePage ctp = new CreateTimetablePage(driver);
		WebActionUtility wLib = new WebActionUtility();
		wLib.selectByText(dayDropdown,day);
		wLib.selectByText(subjectDropdown, subject);
		wLib.selectByText(teacherDropdown, teacher);
		wLib.selectByText(clsroomDropdown, classroom);
		ctp.getStartTimeEdtTxt().sendKeys(startTime);
		ctp.getEndTimeEdtTxt().sendKeys(endTime);
		ctp.getsubjectRoutingSubmitBtn().click();

	}
}