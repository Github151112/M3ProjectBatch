package com.Demowebshop.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	static Sheet sheet;

	public static Object[][] getMultipleData(String path, String sheetName) {
		FileInputStream f;
		Workbook book;
		try {
			f = new FileInputStream(path);
			book = WorkbookFactory.create(f);
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {

		}

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
