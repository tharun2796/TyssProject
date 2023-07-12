package sms_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.genericutility.ExcelUtility;
import com.ish.genericutility.FileUtility;
import com.ish.genericutility.JavaUtility;
import com.ish.genericutility.WebActionUtility;
import com.ish.objectrepository.AllStudentPage;
import com.ish.objectrepository.CreateStudentPage;
import com.ish.objectrepository.HomePage;
import com.ish.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateStudentTest extends BaseClass{
	@Test
	public void createStudent() throws Throwable {

		//test script data
		int randomNum = jLib.getRandomNumber();
		String mailExtension = "@gmail.com";

		// testscript data from excel
		String INDEXNUM = randomNum+"";
		String STUDENT_NAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Name");
		String STUDENT_FULLNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "FullName")+randomNum; 
		String STUDENT_ADDRESS = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Address");
		String STUDENT_EMAIL = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Email")+randomNum+mailExtension;
		String STUDENT_PHONENUM = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "PhoneNumber");
		String STUDENT_BIRTHDAY = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Birthday");
		String STUDENT_GENDER = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Gender");
		String STUDENT_IMG_PATH = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "StudentImagePath");

		String PARENT_NAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentName");
		String PARENT_FULLNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentFullName")+randomNum; 
		String PARENT_ADDRESS = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentAddress");
		String PARENT_EMAIL = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentEmail")+randomNum+mailExtension;
		String PARENT_PHONENUM = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentPhoneNumber");
		String PARENT_BIRTHDAY = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentBirthday");
		String PARENT_GENDER = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentGender");
		String PARENT_IMGPATH = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "ParentImagePath");

		String STUDENT_GRADE = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Grade");
		
		// To Navigate to Create Student page
		HomePage hp = new HomePage(driver);
		hp.getStudentLink().click();
		hp.getAddStudentLink().click();

		// To fill all the details of student
		CreateStudentPage csp = new CreateStudentPage(driver);
		csp.createStudent(driver, INDEXNUM, STUDENT_NAME, STUDENT_FULLNAME, STUDENT_ADDRESS, STUDENT_EMAIL, STUDENT_PHONENUM, STUDENT_BIRTHDAY, STUDENT_GENDER, STUDENT_IMG_PATH);
		csp.createParent(driver, PARENT_NAME, PARENT_FULLNAME, PARENT_ADDRESS, PARENT_EMAIL, PARENT_PHONENUM, PARENT_BIRTHDAY, PARENT_GENDER, PARENT_IMGPATH);

		WebElement grade = csp.getGradeDropdown();	    
		wLib.selectByText(grade, STUDENT_GRADE);

		List<WebElement> allSubjects = driver.findElements(By.xpath("//tr/td/input[@id='checkbox']"));

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(allSubjects));

		for (int i = 0; i <allSubjects.size(); i++) {
			allSubjects.get(i).click();
		}

		csp.getSubmitBtn().click();
		csp.getCloseBtn().click();

		// To refresh the page
		driver.navigate().refresh();

		WebElement studentTab = hp.getStudentLink(); 
		wLib.waitForElement(driver,studentTab);

		hp.getStudentLink().click();
		hp.getAllStudentLink().click();

		AllStudentPage asp = new AllStudentPage(driver);
		WebElement gradeDropdown = asp.getGradeDropdown();
		wLib.selectByText(gradeDropdown, STUDENT_GRADE);
		asp.getSubmitBtn().click();
		asp.getSearchEditTxt().sendKeys(STUDENT_FULLNAME);
		
		String expectedStudentName = STUDENT_FULLNAME;
        String actualStudentName = asp.getStudentNameLink().getText();
		
        Assert.assertTrue(actualStudentName.equals(expectedStudentName),actualStudentName+" is not Created and not Verified");
        Reporter.log(actualStudentName+" is Created and Verified",true);
        		
	} 
}
