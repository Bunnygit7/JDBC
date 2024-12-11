package com.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc_pro11 
{
	String db_url="jdbc:oracle:thin:@localhost:1521:xe";
	String db_uname="system";
	String db_pwd="manager";
	String sql="Select * from employee";
	
	void meth()
	{
		try 
		{
			RowSetFactory rsf=RowSetProvider.newFactory();
			JdbcRowSet jrs=rsf.createJdbcRowSet();
			
			jrs.setUrl(db_url);
			jrs.setUsername(db_uname);
			jrs.setPassword(db_pwd);
			
			
			jrs.setCommand(sql);
			jrs.execute();
			
			
			while(jrs.next())
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			
			
			System.out.println("---------------------------------------");
			
			
			jrs.afterLast();
			
			while(jrs.previous())
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro11().meth();
	}
}
