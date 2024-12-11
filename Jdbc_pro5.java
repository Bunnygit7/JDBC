package com.jdbc;
//inserting data into table (data taken from user)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro5 
{
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	Scanner sc=new Scanner(System.in);
	String sql1="select * from employee";
	void insertData()
	{
		System.out.print("enter your id:");
		String eid=sc.nextLine();
		System.out.print("enter your employee first name:");
		String EFname=sc.nextLine();
		System.out.print("enter your employee last name:");
		String ELname=sc.nextLine();
		System.out.print("enter your employee salary:");
		int Esal=Integer.parseInt(sc.nextLine());
		System.out.print("enter your employee address:");
		String Eadd=sc.nextLine();
		try
		{
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			Statement st=con.createStatement();
			int rowCount=st.executeUpdate("insert into employee values('"+eid+"','"+EFname+"','"+ELname+"',"+Esal+",'"+Eadd+"')");
			if(rowCount>0)
			{
				System.out.println("data inserted");
			}
			else
			{
				System.out.println("data not inserted");
			}
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" ");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Jdbc_pro5 obj=new Jdbc_pro5();
		obj.insertData();
		
	}

}
