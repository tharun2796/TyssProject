package sms_practice;
import java.time.Duration;
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
import com.ish.objectrepository.CreateExamPage;
import com.ish.objectrepository.HomePage;



public class CreateExamTest extends BaseClass {

	@Test
	public void createExam() throws Throwable {
		
		/*test script data*/
		int randomNum = jLib.getRandomNumber();

		String EXAMNAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "exam" , "tc_01", "ExamName")+ randomNum;

		Thread.sleep(3000);
		
	/*	String scroll_200 = "(window.scrollTo(0,100))";
		wLib.executeJavaScript(driver,scroll_200);
    */
	
		/* To navigate to CreateExamPage */
		HomePage hp = new HomePage(driver);
		hp.getExamLink().click();
		hp.getCreateExamLink().click();

		CreateExamPage cp = new CreateExamPage(driver);
		cp.createExam(EXAMNAME);

		Thread.sleep(3000);
		
		WebElement visibleText = cp.getAddBtn();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibleText));

		cp.getSearchEditTxt().sendKeys(EXAMNAME);
		String actualExamName = cp.getFetchExamName().getText();

	    Assert.assertEquals(actualExamName,EXAMNAME);
	    Reporter.log(actualExamName+" is Created and verified",true);
		/*	if (actualExamName.equals(EXAMNAME)) {
			System.out.println("The Exam is Verified");
		} else {
			System.out.println("The Exam is not Verified");
		}
    */
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

		int randomNum = new Random().nextInt(100);

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,200)");	

		driver.findElement(By.xpath("//span[text()='Exam']")).click();
		driver.findElement(By.linkText("Create Exam")).click();	


		String expectedExamName = "PublicExam"+randomNum;
		driver.findElement(By.partialLinkText("Add")).click();
		driver.findElement(By.id("name")).sendKeys(expectedExamName);

		driver.findElement(By.id("btnSubmit")).click();

		Thread.sleep(5000);

		/*WebElement visibleText = driver.findElement(By.partialLinkText("Add"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibleText));


		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expectedExamName);
		String actualExamName = driver.findElement(By.xpath("//div/table/tbody/tr/td[2]")).getText();

		if (actualExamName.equals(expectedExamName)) {
			System.out.println("The Exam is Verified");
		} else {
			System.out.println("The Exam is not Verified");
		}
		 */
		/*
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		// To click on Signout button
		driver.findElement(By.linkText("Sign out")).click();

		driver.close();
		 */
	
