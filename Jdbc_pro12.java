package com.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc_pro12 
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
			CachedRowSet crs=rsf.createCachedRowSet();
			crs.setUrl(db_url);
			crs.setUsername(db_uname);
			crs.setPassword(db_pwd);
			crs.setCommand(sql);
			crs.execute();
			
//			crs.close();
			
			while(crs.next())
			{
				String id=crs.getString(1);
				if(id.equals("10"))
				{
					System.out.println("Updating the data");
					crs.updateInt(4, 5000);
					crs.updateRow();
				}
			}
			crs.acceptChanges();
			System.out.println("updated Successfully!!!");
			
			System.out.println("------------------------------");
			
			crs.beforeFirst();
			while(crs.next())
			{
				String id=crs.getString(1);
				if(id.equals("10"))
				{
					System.out.println("Updated the data");
					System.out.println(crs.getString(1)+" "+crs.getString(2)+" "+crs.getString(3)+" "+crs.getInt(4)+" "+crs.getString(5));
				}
			}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Jdbc_pro12().meth();
	}

}
