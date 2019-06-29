package com.demo.excel.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("UserInfo"); 

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{ "ID", "UserName", "Password" });
        data.put("2", new Object[]{ 1, "uname1", "Pass1" });
        data.put("3", new Object[]{ 2, "uname2", "Pass2" }); 

        Set<String> keyset = data.keySet();
        
        int rownum = 0;
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {

                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/testFile/TestData.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("File written successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
