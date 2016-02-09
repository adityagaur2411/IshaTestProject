package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BrowserToExecute {

	public List<String> getBrowser(Object workbook, String strSheetName) {
		
		String strBrowser = null;
		XSSFWorkbook wb = (XSSFWorkbook) workbook;		
		XSSFSheet sheet = wb.getSheet(strSheetName);
		List<String> browserList = new ArrayList<>();

		int intLastRow = sheet.getLastRowNum();
		
		for (int j = 0; j <= intLastRow; j++) {
			XSSFRow Row = sheet.getRow(j);
			XSSFCell browserType = Row.getCell(0);
			XSSFCell flag = Row.getCell(1);

			if (browserType.getCellType() == XSSFCell.CELL_TYPE_STRING
					&& flag.getCellType() == XSSFCell.CELL_TYPE_STRING) {

				strBrowser = browserType.getStringCellValue();
				String strExecuteFlag = flag.getStringCellValue();

				if (strExecuteFlag.equalsIgnoreCase("Yes")) {
					browserList.add(strBrowser);
				}
			}
		}

		return browserList;
	}

}
