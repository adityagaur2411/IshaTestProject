package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	XSSFWorkbook wb = null;
	
	public Object openExcel(String strFileName){
		InputStream fileObject = null;
				
		
		try {
			fileObject = new FileInputStream(strFileName);
			wb = new XSSFWorkbook(fileObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb;
	}
	
	public Object getFieldValue(String strSheetName, String strFieldName, String strDataId){
		int intColIndex = 0;
		int intRowIndex = 0;		
		
		XSSFSheet sheet = wb.getSheet(strSheetName);
		int intFirstRow = sheet.getFirstRowNum();
		XSSFRow FirstRow = sheet.getRow(intFirstRow);
		int intColNum = FirstRow.getLastCellNum();
		
		
		if (strFieldName == "") {
			intColIndex = 1;
		} else{
			
			for (int i =0; i<=intColNum; i++) {
				XSSFCell cell = FirstRow.getCell(i);
				
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					String text = cell.getStringCellValue();
					
					if (strFieldName.equalsIgnoreCase(text)) {
						intColIndex = i;
						break;
					}
				}
			}
		}
		
		int intLastRow = sheet.getLastRowNum();
		
		for (int j=0; j<=intLastRow; j++) {
			XSSFRow Row = sheet.getRow(j);
			XSSFCell cell = Row.getCell(0);
			
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				String dataId = cell.getStringCellValue();
				if (strDataId.equalsIgnoreCase(dataId)) {
					intRowIndex = j;
					break;
				}
			}
		}
		
		XSSFRow Row = sheet.getRow(intRowIndex);
		XSSFCell cell = Row.getCell(intColIndex);
		String dataValue = cell.getStringCellValue();
		
		return dataValue;
		
	}

}
