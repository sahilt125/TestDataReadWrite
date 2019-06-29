package com.demo.properties.test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GetProperties {
	
	static String envFileName;
  
  public static void main(String[] args) {
	  envFileName = "Qa";
	  
	  GetProperties prop = new GetProperties();
	  String url = prop.getProperties("url");
	  System.out.println(url);
  }
  
	public String getProperties(String key) {
		Properties prop = new Properties();
		String value = null;
		try {
			String path = System.getProperty("user.dir")+"\\testFile\\"+envFileName+".properties";
			System.out.println(path);			
			File f = new File(path);
			FileReader reader=new FileReader(f);		    
			prop.load(reader);
			System.out.println(prop.getProperty(key));
			value = prop.getProperty(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

}
