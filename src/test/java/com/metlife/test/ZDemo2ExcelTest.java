package com.metlife.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//    will be deleted
public class ZDemo2ExcelTest {

    public static void main(String[] args) throws IOException {

        FileInputStream file=new FileInputStream("test-data/OpenEMRData.xlsx");

        XSSFWorkbook book=new XSSFWorkbook(file);

        XSSFSheet sheet= book.getSheet("validLoginTest");

        Object[][] data=new Object[2][3];
        //logic to print all cell values
        for(int r=1;r<3;r++)
        {
            for(int c=0;c<3;c++)
            {
                String cellValue= sheet.getRow(r).getCell(c).getStringCellValue();
                System.out.println(cellValue);
                data[0][0]=cellValue;
            }
        }

        book.close();
        file.close();

    }
}
