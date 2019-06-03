package org.cts;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcEx {
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			if(con!=null)
				System.out.println("connection established");
			else
				System.out.println("not established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
