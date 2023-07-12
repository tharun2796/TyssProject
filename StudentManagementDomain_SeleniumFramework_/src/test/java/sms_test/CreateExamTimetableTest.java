package sms_test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.objectrepository.CreateTimetablePage;
import com.ish.objectrepository.HomePage;

@Listeners(com.ish.genericutility.ListenerImplementaion.class)
public class CreateExamTimetableTest extends BaseClass{
	@Test(groups={"smokeTest","regresTest"})
	public void createExamTimetable() throws Throwable {

		//test script data
		String GRADE = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable" , "tc_01", "Grade");
		String DAY = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "Day");
		String SUBJECT = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "Subject");
		String TEACHER = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "Teacher");
		String CLASSROOM = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "Classroom");
		String START_TIME = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "StartTime");
		String END_TIME = eLib.getDataFromExcelBasedTestId(excelFilePath, "timetable", "tc_01", "EndTime");

		HomePage hp = new HomePage(driver);
		hp.getTimetableLink().click();

		// To navigate to Timetable page
		CreateTimetablePage ctp = new CreateTimetablePage(driver);
		ctp.selectGrade(driver, GRADE);
		ctp.getAddBtn().click();
		ctp.addSubjectRouting(driver, DAY, SUBJECT, TEACHER, CLASSROOM, START_TIME, END_TIME);

		WebElement visibilityOfAddBtn = ctp.getAddBtn();
		wLib.waitForElement(driver, visibilityOfAddBtn);
	}
}
