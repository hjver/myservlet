package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnet {
	
	public Connection getConnection() throws Exception{
		
		String db_driver = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/project";
		String db_user = "project";
		String db_passwd = "a123456";

		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);
		
		return con;
	}
}
