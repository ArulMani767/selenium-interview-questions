package com.automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataDrivenTest extends TestBase {
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        String excelPath = "src/test/resources/testdata.xlsx"; // Path to excel file
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Skip header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "excelData")
    public void testLoginWithExcelData(String username, String password) {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(org.openqa.selenium.By.id("username")).sendKeys(username);
        driver.findElement(org.openqa.selenium.By.id("password")).sendKeys(password);
        System.out.println("Tested login for user: " + username);
    }
}
