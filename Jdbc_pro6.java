package com.jdbc;
//Deleting data from table using eid(taken from user)
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro6 {
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	Scanner sc=new Scanner(System.in);

	void deleteData() {
		System.out.print("Enter id of employee to delete:");
		String eid=sc.next();
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			Statement st=con.createStatement();
			int rowCount=st.executeUpdate("delete from employee where Eid="+eid);
			System.out.println(rowCount);
			if(rowCount>0)
			{
				System.out.println("Deleted sussfully");
			}
			else
			{
				System.out.println("not deleted");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		Jdbc_pro6 obj=new Jdbc_pro6();
		obj.deleteData();
	}
}
