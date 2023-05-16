package mysqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLCommands {
	
	public static void main(String[] args) throws SQLException {
		
		//1)Create a connection-Similar to what we do in MySQL  Workbench
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		//2)Create statement/Query
		Statement stmt = con.createStatement();
		//3)Execute statement/Query
		String query = "INSERT INTO STUDENT VALUES(106,'Kiran', 6,57)";
		//String query = "UPADTE STUDENT SET SNAME = 'David' WHERE SID = 106";
		//String query = "DELETE FROM STUDENT WHERE SID=106";
		stmt.execute(query);
		//4)Close connection
		con.close();
		
		
	}

}
