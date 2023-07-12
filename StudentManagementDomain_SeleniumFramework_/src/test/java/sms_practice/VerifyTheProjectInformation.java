package sms_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class VerifyTheProjectInformation {

	public static void main(String[] args) throws SQLException{
		Connection conn = null;
		String projectName = "Suriya";
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String query = "select * from project";
			ResultSet result = statement.executeQuery(query);
			boolean flag = false;
			while(result.next()) {
				String value = result.getString(2);
				if (value.equalsIgnoreCase(projectName)) {
					System.out.println("Project is Created");
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Project is not Created");
			}
		}
		finally {
			conn.close();
		}
	}

}
