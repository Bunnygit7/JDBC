package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro4 {
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	Scanner sc=new Scanner(System.in);
	String sqlQuery1="insert into employee values('5','john','a',10000,'charminar')";
	String sqlQuery2="select * from employee";
	void insertData()
	{
		System.out.println("inserting data");
		try 
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			Statement st=con.createStatement();
			int rowCount=0;
			rowCount=st.executeUpdate(sqlQuery1);
			if(rowCount>0) 
			{
				System.out.println("data inserted successfully");
				System.out.println("do you want to view the data(y/n):");
				switch(sc.next())
				{
				case "y":
					ResultSet rs=st.executeQuery(sqlQuery2);
					while(rs.next()) {
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
					}
					break;
				case "n":
					System.out.println("Thank you!!!");	
				}
			}
			else
			{
				System.out.println("Something went wrong data not inserted");
			}
			con.close();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Jdbc_pro4 obj=new Jdbc_pro4();
		obj.insertData();
	}

}
