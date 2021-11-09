package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

//public static void main(String[] args) throws IOException {

    public ArrayList<String> getdata(String testCaseName) throws IOException {

        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\TRAINING\\TestData\\TestDataExcel.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) //iterate through each sheet

        {

            if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {

                XSSFSheet sheet = workbook.getSheetAt(i); //grab "TestData" sheet

                Iterator<Row> rows = sheet.iterator(); //Iterate through each row

                Row firstrow = rows.next(); //we are on first row now

                Iterator<Cell> ce = firstrow.cellIterator(); //iterate through each cell of first row

                int k = 0;

                int column = 0;

                while (ce.hasNext()) //looping till the time cell is present

                {

                    Cell value = ce.next(); //In 1st loop, we are on 1st cell of 1st row.

//In 2nd loop (if any), we will move to 2nd cell of 1st row

                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {

//grab desired column

                        column = k;

                    }

                    k++;

                }

//System.out.println(column);

                while (rows.hasNext()) {

                    Row r = rows.next();

//if(r.getCell(column).getStringCellValue().equalsIgnoreCase("TC3"))

                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {

//after grabbing "TC3" test case row, we will grab all the cell contents of that row

                        Iterator<Cell> cv = r.cellIterator(); //Iterate through each cell of TC3 row

                        while (cv.hasNext()) {

//System.out.println(cv.next().getStringCellValue());

//a.add(cv.next().getStringCellValue());

                            Cell c = cv.next();
//
//                            if (c.getCellType() == XSSFCell.CELL_TYPE_STRING) {
//
//                                a.add(c.getStringCellValue());
//
//                            } else {
//
//                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
//
//                            }

                        }

                    }

                }

            }

        }

        return a;

    }

}