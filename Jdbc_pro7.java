package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_pro7 
{
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	Scanner sc=new Scanner(System.in);
	String sqlQuery="select * from ";

	
	
	Connection testConnect() 
	{
//		System.out.println("connection");
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(db_url, db_uname, db_pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1()//reading
	{
		System.out.println("Retriving the data from the table");
		System.out.print("enter the table name:");
		String tName=sc.next();
		try 
		{
			Connection con=testConnect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sqlQuery.concat(tName));
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			con.close();
			
		} 
		catch (SQLSyntaxErrorException e) {
			
			System.out.println("There is no table with name:"+tName);
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		sc.close();
	}
	void meth2()//Inserting
	{
		System.out.println("Inserting Data into table");
		try 
		{
			Connection con=testConnect();
			Statement st=con.createStatement();
			System.out.println("enter id:");
			String eid=sc.nextLine();
			System.out.println("enter employee first name:");
			String eFname=sc.nextLine();
			System.out.println("enter employee last name:");
			String eLname=sc.nextLine();
			System.out.println("enter employee salary:");
			int eSal=Integer.parseInt(sc.nextLine());
			System.out.println("enter employee address:");
			String eAdd=sc.nextLine();
			
			int rowCount=st.executeUpdate("insert into employee values('"+eid+"','"+eFname+"','"+eLname+"',"+eSal+",'"+eAdd+"')");
			if(rowCount>0)
			{
				System.out.println("data inserted");
				meth1();
			}
			else
			{
				System.out.println("Data not inserted");
			}
			con.close();		
		} 
		catch (SQLIntegrityConstraintViolationException e) 
		{
			System.out.println("Duplicate data not accepted!!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		sc.close();
	}
	void meth3()//Reading through eid
	{
		System.out.println("retriving data from employee table using eid");
		try
		{
			System.out.println("enter employee id:");
			String eid=sc.next();
			Connection con=testConnect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee where Eid="+eid);
		
			if(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			else
			{
				System.out.println("Employee not present");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}
	void meth4()//updating
	{
		System.out.println("Updating data using eid");
		try
		{
			System.out.print("Enter employee id:");
			String eid=sc.nextLine();
			Connection con=testConnect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee where Eid="+eid);
			if(rs.next())
			{
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.print("Enter First Name:");
				String eFname=sc.nextLine();
				System.out.print("Enter Last Name:");
				String eLname=sc.nextLine();
				System.out.print("Enter Salary:");
				int eSal=Integer.parseInt(sc.nextLine());
				System.out.print("Enter Address:");
				String eAdd=sc.nextLine();
				int rowCount=st.executeUpdate("update employee set EFname='"+eFname+"',ELname='"+eLname+"',Esal="+eSal+",EAddress='"+eAdd+"' where Eid='"+eid+"'");
				
				if(rowCount>0)
				{
					System.out.println("Data updated successfully!!");
					ResultSet rs1=st.executeQuery("select * from employee where Eid="+eid);
					while(rs1.next())
					{
						System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getInt(4)+" "+rs1.getString(5));
					}
//					meth3();
					
				}
				else
				{
					System.out.println("Data is not updated!!");
				}

			}
			else
			{
				System.out.println("employee not found!!");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}
	void meth5()//deleting
	{
		System.out.println("Deleting data");
		System.out.print("enter employee id:");
		String eid=sc.nextLine();
		try 
		{
			Connection con=testConnect();
			Statement st=con.createStatement();
			
			int rowCount=st.executeUpdate("delete from employee where Eid="+eid);

			if(rowCount>0) 
			{
				System.out.println("Data deleted successfully!!!");
				meth1();
			}
			else
			{
				System.out.println("Something went wrong!!");
			}
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public static void main(String[] args) {
		Jdbc_pro7 obj=new Jdbc_pro7();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Display table.");
		System.out.println("2.Insert int table.");
		System.out.println("3.Display details of Eid.");
		System.out.println("4.Update employe details.");
		System.out.println("5.Delete employe details");
		System.out.print("Enter your choice:");
		
		switch(sc.nextInt())
		{
		case 1:
			obj.meth1();
			break;
		case 2:
			obj.meth2();
			break;
		case 3:
			obj.meth3();
			break;
		case 4:
			obj.meth4();
			break;
		case 5:
			obj.meth5();
			break;
		default:
			System.out.println("Invalid Choice");
		}
		sc.close();
//		obj.testConnect();
//		obj.meth1();//Reading whole table
//		obj.meth2();//Inserting data
//		obj.meth3();Reading through eid
//		obj.meth4();//Updating
//		obj.meth5();//Deleting
	}
}
