package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_pro9 {
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	void meth()
	{
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//Statement st=con.createStatement(1004,1007);//above line this line are same
			ResultSet rs=st.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			System.out.println("---------------------------");
			rs.last();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			System.out.println("---------------------------");
			rs.afterLast();
			
			while(rs.previous())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			System.out.println("---------------------------");
			rs.beforeFirst();
			if (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			System.out.println("---------------------------");
			rs.absolute(5);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			
			System.out.println("---------------------------");
			rs.absolute(-3);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			
			System.out.println("---------------------------");
			rs.relative(1);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			
			System.out.println("---------------------------");
			rs.relative(-5);
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			
			System.out.println("---------------------------");
			rs.first();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));

			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Jdbc_pro9().meth();
	}

}
