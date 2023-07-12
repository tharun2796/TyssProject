package sms_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PracticeClass {

	public static void main(String[] args) throws IOException {
	PracticeClass pc = new PracticeClass();
	
	String value = pc.getFilePathFromPropertiesFile("testScriptdatafilePath");
	System.out.println(value);
	
	String value1 = pc.getFilePathFromPropertiesFile("databaseConfigFilePath");
	System.out.println(value1);
	
	String value2 = pc.getFilePathFromPropertiesFile("projectConfigDataFilePath");
	System.out.println(value2);
	}
	
	public String getFilePathFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config/filepath.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
}
