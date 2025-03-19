package com.Demowebshop.genericLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static Object[][] getMultipleData(String path, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows();
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] o = new Object[row - 1][cell];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				o[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return o;
	}
	
	
}
