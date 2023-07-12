package sms_practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.genericutility.ExcelUtility;
import com.ish.genericutility.FileUtility;
import com.ish.genericutility.JavaUtility;
import com.ish.genericutility.WebActionUtility;
import com.ish.objectrepository.CreateTimetablePage;
import com.ish.objectrepository.HomePage;
import com.ish.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateExamTimetableTest extends BaseClass{
	@Test
	public void createExamTimetableMethod() throws Throwable  {

		/*test script data*/
		
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

		/*		WebElement element = driver.findElement(By.id("email"));
		WebDriverWai;t wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(element));

		// To enter name of the email in Email textfield
		driver.findElement(By.id("email")).sendKeys(USERNAME);

		// To enter name of the password in Password textfield
		driver.findElement(By.id("password")).sendKeys(PASSWORD);

		// To click on Submit button
		driver.findElement(By.id("btnSubmit")).click();

		/*	FileInputStream fis = new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		//To set the path of the driver file
		WebDriverManager.chromedriver().setup();

		// Upcasting ChromeDriver to WebDriver Interface
		WebDriver driver = new ChromeDriver();

		//To manage the waiting time for findElement and findElements 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// To maximize the Window
		driver.manage().window().maximize();

		// Enter the URL to go to Login page
		driver.get(URL);

		WebElement element = driver.findElement(By.id("email"));
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(element));

		// To enter name of the email in Email textfield
		element.sendKeys(USERNAME);

		// To enter name of the password in Password textfield
		driver.findElement(By.id("password")).sendKeys(PASSWORD);

		// To click on Submit button
		driver.findElement(By.id("btnSubmit")).click();

		// To click on Timetable tab
		driver.findElement(By.xpath("//span[.='Timetable']")).click();

		// To select Grade KG in the Grade dropdown
		WebElement grade = driver.findElement(By.id("grade"));
		Select s = new Select(grade);
		s.selectByVisibleText("Grade KG");

		// To click on Submit button
		driver.findElement(By.xpath("//button[.='Submit']")).click();

		// To click on Add button
		driver.findElement(By.partialLinkText("Add")).click();

		// To select Wednesday in the Day dropdown 
		WebElement day = driver.findElement(By.id("day"));
		Select s1 = new Select(day);
		s1.selectByValue("Wednesday");

		// To select Maths in the Subject dropdown
		WebElement subject = driver.findElement(By.id("subject"));
		Select s2 = new Select(subject);
		s2.selectByValue("392");

		//Thread.sleep(3000);

		// To select Leela L in the Teacher dropdown
		WebElement teacher = driver.findElement(By.id("teacher"));
		Select s3 = new Select(teacher);
		s3.selectByIndex(1);

		//Thread.sleep(3000);

		// To select Class A in the Classroom dropdown
		WebElement classroom = driver.findElement(By.id("classroom"));		
		Select s4 = new Select(classroom);
		s4.selectByVisibleText("Class A");

		//Thread.sleep(3000);

		// To enter 10.00 in the Start Time textfield
		driver.findElement(By.id("start_time")).sendKeys("10.00");

		//Thread.sleep(3000);

		// To enter 12.00 in the End Time textfield
		driver.findElement(By.id("end_time")).sendKeys("12.00");

		// To click on Submit button
		driver.findElement(By.id("btnSubmit")).click();

		WebElement visibilityOfText = driver.findElement(By.xpath("//a[contains(text(),'ILove')]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(visibilityOfText));

		/*
		  To scroll to top of the window
		//JavascriptExecutor j= (JavascriptExecutor) driver;
		//j.executeScript("window.scrollTo(0,0)");

		WebElement visibilityOfText1 = driver.findElement(By.xpath("//span[text()='Ingenious Developer1']"));
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOf(visibilityOfText1));
		 */

		// To click on Admin dropdown
		/*		//driver.findElement(By.xpath("//span[text()='Ingenious Developer1']")).click();
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		// To click on Signout button
		driver.findElement(By.linkText("Sign out")).click();
		// To close the browser
		driver.close();
		 */
	}


}
