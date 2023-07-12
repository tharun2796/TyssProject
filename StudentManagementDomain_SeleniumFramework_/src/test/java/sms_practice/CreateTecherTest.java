package sms_practice;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ish.genericutility.BaseClass;
import com.ish.genericutility.ExcelUtility;
import com.ish.genericutility.FileUtility;
import com.ish.genericutility.JavaUtility;
import com.ish.genericutility.WebActionUtility;
import com.ish.objectrepository.AllTeacherPage;
import com.ish.objectrepository.CreateTeacherPage;
import com.ish.objectrepository.HomePage;
import com.ish.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTecherTest extends BaseClass{
	@Test
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

/*  FileInputStream fis = new FileInputStream("./src/test/resources/data/commondata.properties");
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

		driver.findElement(By.xpath("//span[.='Teacher']")).click();

		driver.findElement(By.xpath("//li/a[contains(.,'Add Teacher')]")).click();

		//To generate random number for Student name
		int randomNum = new Random().nextInt(100);

		// To locate the Index Number
		driver.findElement(By.id("index_number")).sendKeys(""+randomNum);

		driver.findElement(By.id("full_name")).sendKeys("Saran");

		String expectedName = "Saran S"+randomNum;
		WebElement expectRes = driver.findElement(By.id("i_name"));
		expectRes.sendKeys(expectedName);

		driver.findElement(By.id("address")).sendKeys("Bangalore");

		WebElement gender = driver.findElement(By.id("gender"));
		Select s = new Select(gender);
		s.selectByIndex(1);

		driver.findElement(By.id("phone")).sendKeys("123-345-4567");

		driver.findElement(By.id("email")).sendKeys("Saran"+randomNum+"@gmail.com");

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,220)");

		File f = new File("./src/test/resources/data/Teacher.png");
		String absolutePath = f.getAbsolutePath();		
		driver.findElement(By.id("fileToUpload")).sendKeys(absolutePath);

		driver.findElement(By.id("btnSubmit")).click();

		Thread.sleep(5000);
		/*WebElement visibleText = driver.findElement(By.xpath("//span[.='Teacher']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibleText));
 */
//driver.findElement(By.xpath("//li[@class='treeview']/a/span[text()='Teacher']")).click();
/*		//driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//span[text()='Teacher']")).click();
		driver.findElement(By.xpath("//a[text()=' All Teacher']")).click();
		//span[text()='Teacher']

		WebElement searchTxtFld = driver.findElement(By.xpath("//input[@type='search']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchTxtFld));

		searchTxtFld.sendKeys(expectedName);
		////thead/tr/th[@aria-label='Name: activate to sort column ascending']
		String actualName = driver.findElement(By.xpath("//thead/following-sibling::tbody/tr[1]/td/a[@href='#modalViewform']")).getText();
		System.out.println(actualName);

		if (actualName.equals(expectedName)) {
			System.out.println("The Test is Passed");
		} else {
			System.out.println("The Test is not Passed");
		}

		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		// To click on Signout button
		driver.findElement(By.linkText("Sign out")).click();

		driver.close();
 */

