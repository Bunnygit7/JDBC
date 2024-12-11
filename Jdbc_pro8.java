package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Jdbc_pro8 {
	
	
	String driver="oracle.jdbc.OracleDriver";
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	Scanner sc=new Scanner(System.in);
	Connection testConnect()
	{
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
	void operation()
	{
		try
		{
			Connection con=testConnect();
			PreparedStatement psmt1=con.prepareStatement("insert into patient values (?,?,?,?)");
			PreparedStatement psmt2=con.prepareStatement("select * from patient");
			PreparedStatement psmt3=con.prepareStatement("select * from patient where pid=?");
			PreparedStatement psmt4=con.prepareStatement("update patient set age=? where pid=?");
			PreparedStatement psmt5=con.prepareStatement("delete from patient where pid=?");
			
			while(true)
			{
				System.out.println("welcome");
				System.out.println("1.insert patient data.\n2.view patients data.\n3.retspecific data\n4.update. \n5.delete.\n6.exit");
				System.out.println("enter your choice:");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("insserting patient data\n");
					System.out.println("enter patient id");
					sc.nextLine();
					String pid=sc.nextLine();
					System.out.println("patient name");
					String pName=sc.nextLine();
					System.out.println("patient age:");
					int pAge=Integer.parseInt( sc.nextLine());
					System.out.println("enter patient contact");
					long pContact=Long.parseLong(sc.nextLine());
					psmt1.setString(1,pid);
					psmt1.setString(2, pName);
					psmt1.setInt(3, pAge);
					psmt1.setLong(4, pContact);
					int rowCount=psmt1.executeUpdate();
					if(rowCount>0)
					{
						System.out.println("Data inserted");
					}
					else
					{
						System.out.println("data not inserted");
//						System.out.println("enter your database name");
//						String DataBaseName=sc.nextLine();
						
					}
					break;
					case 2:
						System.out.println("patient data");
						ResultSet rs=psmt2.executeQuery();
						while(rs.next()) {
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
						}
						System.out.println("data reterived");
						break;
					case 3:
						System.out.println("retspecific data");
						System.out.println("Enter patient id:");
						String pid1=sc.next();
						psmt3.setString(1, pid1);
						ResultSet rs1=psmt3.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getLong(4));

						}
						else
						{
							System.out.println("data not found");
						}
						break;
					case 4:
						System.out.println("updating");
						System.out.println("Enter patint id:");
						String pid2=sc.next();
						System.out.println("Enter patient age:");
						int age=Integer.parseInt(sc.next());
						psmt4.setInt(1, age);
						psmt4.setString(2,pid2);
						int rowCount1=psmt4.executeUpdate();
						if(rowCount1>0)
						{
							System.out.println("Updated successfully");
							
						}
						else
						{
							System.out.println("Data not updated");
						}
						break;
					case 5:
						System.out.println("Deleting");
						System.out.println("enter patient id:");
						String pid3=sc.next();
						psmt5.setString(1, pid3);
						int rowCount3=psmt5.executeUpdate();
						if(rowCount3>0)
						{
							System.out.println("Data deleted successfully");
						}
						else
						{
							System.out.println("Data not deleted");
						}
						break;
					case 6:
						System.out.println("thank you seeeee youuu sooon");
						System.exit(0);
					default:
						System.out.println("invalid input");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) { 
		Jdbc_pro8 obj=new Jdbc_pro8();
		obj.operation();
	}

}

