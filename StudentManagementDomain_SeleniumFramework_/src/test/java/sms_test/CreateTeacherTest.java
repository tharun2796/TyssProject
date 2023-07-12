package sms_test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.objectrepository.AllTeacherPage;
import com.ish.objectrepository.CreateTeacherPage;
import com.ish.objectrepository.HomePage;

public class CreateTeacherTest extends BaseClass{
	
	@Test(groups={"smokeTest","regresTest"})
	public void createTeacher() throws Throwable {
		
		//test script data
		int randomNum = jLib.getRandomNumber();

		//testscript data from excel
		String INDEXNUM = randomNum+"";
		String TEACHERNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "Name");
		String TEACHERFULLNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "FullName")+randomNum; 
		String ADDRESS = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "Address");
		String GENDER = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "Gender");
		String PHONENUM = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "PhoneNumber");
		String EMAIL = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "Email")+randomNum+"@gmail.com";
		String IMGPATH = eLib.getDataFromExcelBasedTestId(excelFilePath, "teacher" , "tc_01", "ImagePath");


		// To navigate to Teacher page 
		HomePage hp =new HomePage(driver);
		hp.getTeacherLink().click();
		hp.getAddTeacherLink().click();

		// To create the Teacher 
		CreateTeacherPage ctp = new CreateTeacherPage(driver);
		ctp.createTeacher(driver, INDEXNUM, TEACHERNAME, TEACHERFULLNAME, ADDRESS, GENDER, PHONENUM, EMAIL, IMGPATH);

		/*    WebElement teacherLink = hp.getTeacherLink();
				wLib.waitForElement(driver,teacherLink);
		 */
		Thread.sleep(3000);

		// To navigate to All Teacher Link
		hp.getTeacherLink().click();
		hp.getAllTeacherLink().click();

		//Thread.sleep(3000);
		//wLib.waitForElement(driver,);
		AllTeacherPage atp = new AllTeacherPage(driver);
		atp.getSearchEdtTxt().sendKeys(TEACHERFULLNAME);
		String actualTeacherName = atp.getTeacherNameTxt().getText();

		String expectedTeacherName = TEACHERFULLNAME;
		Assert.assertEquals(actualTeacherName, expectedTeacherName);
		//Assert.assertTrue(expectedTeacherName.contains(actualTeacherName),expectedTeacherName+" is not verified");
		Reporter.log(actualTeacherName+" is Verified and pass",true);
	}
}
