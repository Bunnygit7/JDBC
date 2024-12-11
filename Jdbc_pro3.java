package com.jdbc;

import java.sql.Statement;
import java.util.Iterator;
import java.util.TreeSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Jdbc_pro3 
{
	void getconnection() 
	{
		String dirver="oracle.jdbc.OracleDriver";
		String db_url="jdbc:oracle:thin:@localhost:1521:xe";
		String db_user="system";
		String db_pwd="manager";
		System.out.println("Connecting to db");
		String query1="select * from employee";
		TreeSet<String> ts=new TreeSet<String>();
		try {
			Class.forName(dirver);
			Connection con=DriverManager.getConnection(db_url, db_user, db_pwd);
			System.out.println("db connected");
			
			
			
			Statement st= con.createStatement();
			st.executeQuery(query1);
			
			System.out.println("query executed successfully");
			
			
			ResultSet rs=st.getResultSet();
			while(rs.next()) {
				//System.out.printf(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+"\n");
				ts.add(rs.getString(1));
			}
			System.out.println("data : "+ts);
			Iterator<String> i=ts.descendingIterator();
			while(i.hasNext()) {
				System.out.print(i.next()+" ");
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
		Jdbc_pro3 obj=new Jdbc_pro3();
		obj.getconnection();
	}

}
