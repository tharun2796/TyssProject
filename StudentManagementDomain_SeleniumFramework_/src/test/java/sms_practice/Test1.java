package sms_practice;

import com.ish.genericutility.ExcelUtility;
import com.ish.genericutility.FileUtility;

public class Test1 {
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		String excelFilePath = fLib.getFilePathFromPropertiesFile("testScriptDataFilePath");
		String STUDENT_NAME = eLib.getDataFromExcelBasedTestId(excelFilePath, "student" , "tc_01", "Name");
		System.out.println(STUDENT_NAME);
	}
	
}
