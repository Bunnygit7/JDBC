package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_pro10 
{
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	
	void meth()
	{
		System.out.println("Implementing updatable scrollable ResultSet");
		
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select eid,efname,esal from employee");
			while(rs.next())
			{
				String id=rs.getString(1);
				if(id.equals("10"))
				{
					System.out.println("updating the salary for employee:"+id);
					rs.updateInt(3,4000);
					rs.updateRow();
				}
			}
			System.out.println("data updated!!!");
			
			ResultSet rs2=stmt.executeQuery("select * from employee");
			rs2.absolute(4);
			System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getInt(4)+" "+rs2.getString(5));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro10().meth();
	}
}
