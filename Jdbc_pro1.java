package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_pro1 
{
	void getConnection()
	{
		String driver="oracle.jdbc.OracleDriver";
		String db_url="jdbc:oracle:thin:@localhost:1521:xe";
		String db_name="system";
		String db_pwd="manager";
		System.out.println("Connecting our java program to database");
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url,db_name,db_pwd);
			System.out.println("Connection created");
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Jdbc_pro1 obj=new Jdbc_pro1();
		obj.getConnection();
	}
	

}
