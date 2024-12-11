package com.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Jdbc_pro2 
{
	void getconnection() 
	{
		String dirver="oracle.jdbc.OracleDriver";
		String db_url="jdbc:oracle:thin:@localhost:1521:xe";
		String db_user="system";
		String db_pwd="manager";
		System.out.println("Connecting to db");
		String query1="select * from employee";
		try {
			Class.forName(dirver);
			Connection con=DriverManager.getConnection(db_url, db_user, db_pwd);
			System.out.println("db connected");
			Statement st= con.createStatement();
			st.executeQuery(query1);
			System.out.println("query executed successfully");
			ResultSet rs=st.getResultSet();
			while(rs.next()) {
				System.out.printf(rs.getString(1)+" |"+rs.getString(2)+" |"+rs.getString(3)+" |"+rs.getInt(4)+" |"+rs.getString(5)+"\n");
			}
			
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		Jdbc_pro2 obj=new Jdbc_pro2();
		obj.getconnection();
	}

}
