package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.PathHelper;

public final class DataHelper {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void setExcelFile(String filePath, String SheetName) throws Exception {
		String path = ExcelPath(filePath);
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			setExcelWSheet(ExcelWBook.getSheet(SheetName));
		} catch (Exception e) {

			throw (e);
		}

	}

	public static XSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}

	public static void setExcelWSheet(XSSFSheet excelWSheet) {
		ExcelWSheet = excelWSheet;
	}

	// Provide two options: one is for absolute path and one is for the file in the
	// dataset folder.
	private static String ExcelPath(String filePath) {
		if (new File(filePath).exists()) {
			return filePath;
		} else {
			return PathHelper.datasetPath(filePath);
		}
	}

}
