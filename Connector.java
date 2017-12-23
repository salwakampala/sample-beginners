package newproj;

import java.sql.*;

public class Connector
{
	public static Connection LoginConnector()
	{
		try
		{
			//Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pone?useSSL=false", "root" , "salwa123");
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}
