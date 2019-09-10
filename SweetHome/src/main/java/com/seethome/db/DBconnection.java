package com.seethome.db;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
	
	static Connection c=null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException
	{
		
	if(c==null)
	{
		//FileInputStream fis = new FileInputStream("src/main/resources/DB.properties");
		InputStream is = DBconnection.class.getResourceAsStream("/DB.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		Properties prop = new Properties();
		prop.load(reader);
		
		String u= prop.getProperty("URL");
		String user = prop.getProperty("username");
		String pass=prop.getProperty("password");
		String driver = prop.getProperty("driver");
	
		Class.forName(driver);
		 c = DriverManager.getConnection(u,user,pass);
		System.out.println(c);
		return c;
	}
	System.out.println(c);
	return c;
	}
	

	

}
