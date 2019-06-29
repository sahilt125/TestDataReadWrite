package com.demo.testDataProvider.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
  
  String xlFilePath = System.getProperty("user.dir")+"/testFile/TestData.xlsx";
   
  @Test(dataProvider = "userData")
  public void fillUserForm(String userName, String passWord)
  {
     System.out.println("UserName: "+ userName);
     System.out.println("PassWord: "+ passWord);
  }
  

  
   
   
  @DataProvider(name="userData")
  public Object[][] userFormData() throws Exception
  {
      Object[][] testData = readExcel(xlFilePath, "UserInfo");
    		  
      return testData;
  }
  

  
  
  
  public Object[][] readExcel(String FilePath, String SheetName) throws IOException
  {
  	File file=new File(FilePath);
  	FileInputStream fis=new FileInputStream(file);
  	XSSFWorkbook workbook= new XSSFWorkbook(fis);
  	XSSFSheet sheet=workbook.getSheet(SheetName);
  	int totalRows=sheet.getLastRowNum();
  	int totalColums=sheet.getRow(0).getPhysicalNumberOfCells();

  	Object obj[][]=new Object[totalRows][totalColums];
  	for(int i=0;i<totalRows;i++)
  	{
  		obj[i][0]=sheet.getRow(i+1).getCell(0).toString();
  		obj[i][1]=sheet.getRow(i+1).getCell(1).toString();
  	}
  	
  	return obj;
  }
  	
  
}
