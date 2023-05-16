package mysqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SELECTCommand {
	public static void main(String[] args) throws SQLException {
		// 1)Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
		// 2)Create statement/Query
		Statement stmt = con.createStatement();
		// 3)Execute statement/Query
		String query = "SELECT EMPLOYEE_ID,FIRST_NAME,SALARY FROM EMPLOYEES LIMIT 5";
		ResultSet rs = stmt.executeQuery(query);
		// 4)Store data in ResultSet
		while (rs.next()) {
			int eid = rs.getInt("EMPLOYEE_ID");
			String fname = rs.getString("FIRST_NAME");
			int salary = rs.getInt("SALARY");
			System.out.println(eid + " " + fname + " " + salary);
		}
		// 5)Close connection
		con.close();
	}

}
