package com.metlife.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getSheetIntoTwoDimArray(String filePath, String sheetname) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet(sheetname);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

        DataFormatter format = new DataFormatter();

        Object[][] data = new Object[rowCount - 1][cellCount];

        for (int r = 1; r < rowCount; r++) {
            for (int c = 0; c < cellCount; c++) {
                data[r - 1][c] = format.formatCellValue(sheet.getRow(r).getCell(c));
            }
        }
        book.close();
        file.close();
        return data;
    }
}
