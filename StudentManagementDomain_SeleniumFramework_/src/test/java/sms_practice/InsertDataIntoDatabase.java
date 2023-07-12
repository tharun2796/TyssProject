package sms_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String query = "insert into project values('TY_PROJ_1475','Suriya','20/06/95','Tyss','Completed','3')";
			int result = statement.executeUpdate(query);
			if (result==1) {
				System.out.println("Data is Created");
			} else {
				System.out.println("Data is not Created");
			}
		} 
		finally {
			conn.close();
		}

	}

}


