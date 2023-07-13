package sms_test;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.objectrepository.CreateExamPage;
import com.ish.objectrepository.HomePage;

@Listeners(com.ish.genericutility.ListenerImplementaion.class)
public class CreateExamTest extends BaseClass {

	@Test(groups={"smokeTest","regresTest"})
	public void createExam() throws Throwable {

		//test script data
		int randomNum = jLib.getRandomNumber();

		String EXAMNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "exam" , "tc_01", "ExamName")+ randomNum;

		//Thread.sleep(3000);

		//To navigate to CreateExamPage
		HomePage hp = new HomePage(driver);
		hp.getExamLink().click();
		hp.getCreateExamLink().click();

		CreateExamPage cp = new CreateExamPage(driver);
		cp.createExam(EXAMNAME);

		Thread.sleep(3000);

		WebElement visibleText = cp.getAddBtn();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibleText));

	    //Assert.fail();
		
		cp.getSearchEditTxt().sendKeys(EXAMNAME);
		String actualExamName = cp.getFetchExamName().getText();

		Assert.assertEquals(actualExamName,EXAMNAME);
		Reporter.log(actualExamName+" is Created and verified",true);
	}

	@Test(groups={"smokeTest","regresTest"})   
	public void editExam() {
		Reporter.log("Edit Exam is done",true);
	
	}

}
