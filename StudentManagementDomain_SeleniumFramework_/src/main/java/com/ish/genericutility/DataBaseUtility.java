package com.ish.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * used to connect to Db & perform DB specific Operations
 * @author Tharun
 */

public class DataBaseUtility {

	Driver driver;
	Connection connection;
	ResultSet result;
	FileUtility fLib = new FileUtility();
	String URL;
	String USERNAME;
	String PASSWORD;

	public DataBaseUtility() {
		try {
			String filepath = fLib.getFilePathFromPropertiesFile("databaseConfigFilePath");
			URL = fLib.getDataFromProperties(filepath, "url");
			USERNAME = fLib.getDataFromProperties(filepath, "username");
			PASSWORD = fLib.getDataFromProperties(filepath, "password");	
		    }
		catch (Throwable e) {
		}
	}

	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	public void connectDB()  {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB()  {
		try {
			connection.close();
		}catch (Exception e) {
		}

	}
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {	
		result = connection.createStatement().executeQuery(query);
		return result;		
	}

	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int execyteUpdate(String query) throws Throwable {

		int result = connection.createStatement().executeUpdate(query);

		return result;

	}
	/**
	 * This method will execute query based on query and it will verify the data. 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executequeryAndVerify(String query,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
	}
}