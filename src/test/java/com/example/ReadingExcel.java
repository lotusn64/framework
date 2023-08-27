package com.example;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/testData/data.xlsx");
        XSSFWorkbook  workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet  =workbook.getSheet("Sheet1");
       // workbook.getSheetAt(0);

        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();
        System.out.println(totalCells);
        System.out.println(totalRows);
        for(int r = 0; r<=totalRows; r++){
           XSSFRow currentRow =  sheet.getRow(r);
            for(int c= 0; c<totalCells; c++){
              String value =   currentRow.getCell(c).toString();
                System.out.println(value);
                System.out.println();

            }
        }
        workbook.close();
        inputStream.close();
    }
}
