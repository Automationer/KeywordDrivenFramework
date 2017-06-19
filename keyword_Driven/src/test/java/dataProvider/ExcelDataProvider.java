package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		try {

			wb = new XSSFWorkbook(new FileInputStream(new File("./TestCases/InputData.xlsx")));
		} catch (Exception e) {
			System.out.println("Unable to load excel sheet");
			System.out.println(e.getMessage());
		}

	}

	public int rowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}

	public String getData(String sheetName, int row, int cell) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

	public String getData(int sheetIndex, int row, int cell) {
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

}
