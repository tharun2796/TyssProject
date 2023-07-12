package com.ish.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ish.genericutility.WebActionUtility;

public class CreateStudentPage {
	public WebActionUtility wLib = new WebActionUtility();
		
	@FindBy(id="index_number")
	private WebElement studentIndexNumEdtTxt;

	@FindBy(id="full_name")
	private WebElement studentNameEdtTxt;

	@FindBy(id="i_name")
	private WebElement studentFullNameEdtTxt;

	@FindBy(id="address")
	private WebElement studentAddressEdtTxt;

	@FindBy(id="email")
	private WebElement studentMailEdtTxt;

	@FindBy(id="phone")
	private WebElement studentPhoneNumEdtTxt;

	@FindBy(id="b_date")
	private WebElement studentBirthdayEdtTxt;

	@FindBy(id="gender")
	private WebElement studentGenderDropdown;

	@FindBy(id="g_full_name")
	private WebElement parentNameEdtTxt;

	@FindBy(id="g_i_name")
	private WebElement parentFullNumEdtTxt;

	@FindBy(id="g_address")
	private WebElement parentAddressEdtTxt;

	@FindBy(id="g_email")
	private WebElement parentMailEdtTxt;

	@FindBy(id="g_phone")
	private WebElement parentPhoneNumEdtTxt;

	@FindBy(id="g_b_date")
	private WebElement parentBirthdayEdtTxt;

	@FindBy(id="g_gender")
	private WebElement parentGenderDropdown;

	@FindBy(id="fileToUpload")
	private WebElement studentImg;

	@FindBy(id="g_fileToUpload")
	private WebElement parentImg;

	@FindBy(id="btnSubmit")
	private WebElement nextBtn;

	@FindBy(id="grade")
	private WebElement gradeDropdown;

//	@FindBy(xpath = "//tr/td/input[@id='checkbox']")
//	private WebElement subjectCheckbox;

	@FindBy(id="btnSubmit1")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@class='close  ']")
	private WebElement closeBtn;


	public CreateStudentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getStudentIndexNumEdtTxt() {
		return studentIndexNumEdtTxt;
	}


	public WebElement getStudentNameEdtTxt() {
		return studentNameEdtTxt;
	}


	public WebElement getStudentFullNameEdtTxt() {
		return studentFullNameEdtTxt;
	}


	public WebElement getStudentAddressEdtTxt() {
		return studentAddressEdtTxt;
	}


	public WebElement getStudentMailEdtTxt() {
		return studentMailEdtTxt;
	}


	public WebElement getStudentPhoneNumEdtTxt() {
		return studentPhoneNumEdtTxt;
	}


	public WebElement getStudentBirthdayEdtTxt() {
		return studentBirthdayEdtTxt;
	}


	public WebElement getStudentGenderDropdown() {
		return studentGenderDropdown;
	}


	public WebElement getParentNameEdtTxt() {
		return parentNameEdtTxt;
	}


	public WebElement getParentFullNumEdtTxt() {
		return parentFullNumEdtTxt;
	}


	public WebElement getParentAddressEdtTxt() {
		return parentAddressEdtTxt;
	}


	public WebElement getParentMailEdtTxt() {
		return parentMailEdtTxt;
	}


	public WebElement getParentPhoneNumEdtTxt() {
		return parentPhoneNumEdtTxt;
	}


	public WebElement getParentBirthdayEdtTxt() {
		return parentBirthdayEdtTxt;
	}


	public WebElement getParentGenderDropdown() {
		return parentGenderDropdown;
	}


	public WebElement getStudentImg() {
		return studentImg;
	}


	public WebElement getParentImg() {
		return parentImg;
	}


	public WebElement getNextBtn() {
		return nextBtn;
	}


	public WebElement getGradeDropdown() {
		return gradeDropdown;
	}


/*	public WebElement getSubjectCheckbox() {
		return subjectCheckbox;
	}
*/

	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getCloseBtn() {
		return closeBtn;
	}

	// Business Libraries
	public void createStudent(WebDriver driver,String indexNum,String name, String fullName,String address,String mailID,String phoneNum,String dOB,String gender,String imgPath) {
		CreateStudentPage csp = new CreateStudentPage(driver); 
		csp.getStudentIndexNumEdtTxt().sendKeys(indexNum);
		csp.getStudentNameEdtTxt().sendKeys(name);
		csp.getStudentFullNameEdtTxt().sendKeys(fullName);
		csp.getStudentAddressEdtTxt().sendKeys(address);
		csp.getStudentMailEdtTxt().sendKeys(mailID);
		csp.getStudentPhoneNumEdtTxt().sendKeys(phoneNum);
		csp.getStudentBirthdayEdtTxt().sendKeys(dOB);
	    wLib.selectByText(studentGenderDropdown,gender);
	    wLib.fileUpload(driver,studentImg, imgPath);
	}

	public void createParent(WebDriver driver,String name, String fullName,String address,String mailID,String phoneNum,String dOB,String gender,String imgPath) {
		CreateStudentPage csp = new CreateStudentPage(driver); 
		csp.getParentNameEdtTxt().sendKeys(name);
		csp.getParentFullNumEdtTxt().sendKeys(fullName);
		csp.getParentAddressEdtTxt().sendKeys(address);
		csp.getParentMailEdtTxt().sendKeys(mailID);
		csp.getParentPhoneNumEdtTxt().sendKeys(phoneNum);
		csp.getParentBirthdayEdtTxt().sendKeys(dOB);
		wLib.selectByText(parentGenderDropdown, gender);
		wLib.fileUpload(driver, parentImg,imgPath);
	    csp.getNextBtn().click();
	}
}
/*	public void selectCheckBox(WebDriver driver)
	CreateStudentPage csp= new CreateStudentPage(driver);
	csp.
	
	List<WebElement> allSubjects = driver.findElements(By.xpath("//tr/td/input[@id='checkbox']"));

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(allSubjects));

	for (int i = 0; i <allSubjects.size(); i++) {
		allSubjects.get(i).click();
	}
*/

