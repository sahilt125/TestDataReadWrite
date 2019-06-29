package com.demo.json.test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

public class ReadJson {

	public static void main(String[] args) throws IOException {

		String name = getJsonValue("$.AdminCredentials.username");
		System.out.println(name);	

	}
	
	
	public static String getJsonValue(String jsonPath) throws IOException{
		String path = System.getProperty("user.dir")+"\\testFile\\TestData.JSON";
		String jsonString = new String(Files.readAllBytes(Paths.get(path)));
		String value = JsonPath.read(jsonString, jsonPath);		
		return value;	
	}

}
