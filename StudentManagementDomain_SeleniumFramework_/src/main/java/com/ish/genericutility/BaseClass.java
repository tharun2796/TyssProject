package com.ish.genericutility;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ish.objectrepository.HomePage;
import com.ish.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sDriver;
	public WebDriver driver; 
	public FileUtility fLib = new FileUtility();	
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public WebActionUtility wLib = new WebActionUtility();
	public String envFilePath;
	public String excelFilePath;
	
	/**
	 * To connect to MySQL database
	 * @throws SQLException
	 */
	@BeforeSuite(groups={"smokeTest","regresTest"})
	public void connectToDB() throws SQLException {
		dLib.connectDB();
		System.out.println("Database is Connected");	
	}
	
	/**
	 * To open the Browser
	 * @throws Throwable
	 */
	@BeforeClass(groups={"smokeTest","regresTest"})
	public void openBrowser() throws Throwable {
		envFilePath = fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = fLib.getDataFromProperties(envFilePath,"browser");
		String URL = fLib.getDataFromProperties(envFilePath,"url");
    //  String BROWSER =System.getProperty("browser");
    //  String URL =System.getProperty("url");
		
        if(BROWSER.equalsIgnoreCase("chrome")) {		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		sDriver= driver;
		wLib.maximizingTheWindow(driver);
		wLib.waitForElementInDOM(driver);
		driver.get(URL);
		System.out.println("Browser has been successfully Launched");	
	}

	@BeforeMethod(groups={"smokeTest","regresTest"})
	public void loginToApp() throws Throwable {
		excelFilePath = fLib.getFilePathFromPropertiesFile("testScriptDataFilePath");
		String USERNAME = fLib.getDataFromProperties(envFilePath,"username");
		String PASSWORD = fLib.getDataFromProperties(envFilePath, "password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login has been Successful");
	}

	/**
	 * To logout from the application
	 */
	@AfterMethod(groups={"smokeTest","regresTest"})
	public void logoutToApp() {
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("Loggedout from the Application");
	}

	/**
	 * To close the browser
	 */
	@AfterClass(groups={"smokeTest","regresTest"})
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser has been closed");
	}

	/**
	 * to close the MySQL database
	 * @throws SQLException
	 */
	@AfterSuite(groups={"smokeTest","regresTest"})
	public void closeDB() throws SQLException {
		dLib.closeDB();
		System.out.println("Database is closed");
	}

}

