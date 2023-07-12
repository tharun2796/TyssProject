package com.ish.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *  used to read data from external files like text , proprties
 * @author Tharun
 */
public class FileUtility {

	/**
	 * used to get the filepaths from the  ./src/test/resources/config/filepath.properties  FILE
	 * @param key
	 * @return value
	 * @throws Throwable
	 */

	public String getFilePathFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/config/filepath.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

	/**
	 * used to get the key : value from the any properties based on file Path parsmeter 
	 * @param filePath
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromProperties(String filePath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
