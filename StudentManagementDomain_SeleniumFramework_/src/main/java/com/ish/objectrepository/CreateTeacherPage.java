package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ish.genericutility.WebActionUtility;

public class CreateTeacherPage {

	//Declaration
	@FindBy(id="index_number")
	private WebElement indexEdtTxt;

	@FindBy(id="full_name")
	private WebElement teacherNameEdtTxt;

	@FindBy(id="i_name")
	private WebElement teacherFullNameEdtTxt;

	@FindBy(id="address")
	private WebElement teacherAddressEdtTxt;

	@FindBy(id="gender")
	private WebElement teacherGenderDropdown;

	@FindBy(id="phone")
	private WebElement teacherPhoneNumEdtTxt;

	@FindBy(id="email")
	private WebElement teacherEmailEdtTxt;

	@FindBy(id="fileToUpload")
	private WebElement Teacherimg;

	@FindBy(id="btnSubmit")
	private WebElement submitBtn;

	//Initialization
	public CreateTeacherPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getIndexEdtTxt() {
		return indexEdtTxt;
	}

	public WebElement getTeacherNameEdtTxt() {
		return teacherNameEdtTxt;
	}

	public WebElement getTeacherFullNameEdtTxt() {
		return teacherFullNameEdtTxt;
	}

	public WebElement getTeacherAddressEdtTxt() {
		return teacherAddressEdtTxt;
	}

	public WebElement getTeacherGenderDropdown() {
		return teacherGenderDropdown;
	}

	public WebElement getTeacherPhoneNumEdtTxt() {
		return teacherPhoneNumEdtTxt;
	}

	public WebElement getTeacherEmailEdtTxt() {
		return teacherEmailEdtTxt;
	}

	public WebElement getTeacherimg() {
		return Teacherimg;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//Business Library
	public void createTeacher(WebDriver driver,String indexNum,String Name, String fullName,String address,String gender,String phoneNum,String mailID,String imgPath) {
		CreateTeacherPage ctp = new CreateTeacherPage(driver);
		ctp.getIndexEdtTxt().sendKeys(indexNum);
		ctp.getTeacherNameEdtTxt().sendKeys(Name);
		ctp.getTeacherFullNameEdtTxt().sendKeys(fullName);
		ctp.getTeacherAddressEdtTxt().sendKeys(address);
		WebActionUtility wLib= new WebActionUtility();
		wLib.selectByText(teacherGenderDropdown,gender);
		ctp.getTeacherPhoneNumEdtTxt().sendKeys(phoneNum);
		ctp.getTeacherEmailEdtTxt().sendKeys(mailID);
		wLib.fileUpload(driver,Teacherimg,imgPath);
        ctp.getSubmitBtn().click();
	}

}
