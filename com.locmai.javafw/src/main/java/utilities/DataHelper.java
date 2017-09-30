package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import utilities.PathHelper;

public final class DataHelper {
	private Workbook currentWorkbook;
	private Map<String, Sheet> allSheet = new HashMap<String, Sheet>();

	public DataHelper(String filePath) {
		String path = ExcelPath(filePath);
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			currentWorkbook = new XSSFWorkbook(ExcelFile);
			addAllSheet();
		} catch (Exception e) {
		}
	}

	private void addAllSheet() {
		for (int i = 0; i < currentWorkbook.getNumberOfSheets(); i++) {
			Sheet tmpSheet = currentWorkbook.getSheetAt(i);
			allSheet.put(tmpSheet.getSheetName(), tmpSheet);
		}
	}

	public List<String> getColumnData(String headerName, String sheetName) {
		List<String> tmpColumnData = new ArrayList<>();
		Sheet selectedSheet = getSheet(sheetName);
		int columnIndex = getColumnIndex(headerName, selectedSheet);
		
		for (int rowIndex = 1; rowIndex <= selectedSheet.getLastRowNum(); rowIndex++) {
			Row row = selectedSheet.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(columnIndex);
				if (cell != null) {
					tmpColumnData.add(cell.getStringCellValue());
				}
			}
		}
		
		return tmpColumnData;
	}

	private int getColumnIndex(String headerName, Sheet selectedSheet) {
		Row row = selectedSheet.getRow(0);
		int index = 0;

		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (cell.getStringCellValue().equals(headerName)) {
				index = cell.getColumnIndex();
			}
		}
		return index;
	}

	private Sheet getSheet(String sheetName) {
		return allSheet.get(sheetName);
	}

	private static String ExcelPath(String filePath) {
		if (new File(filePath).exists()) {
			return filePath;
		} else {
			return PathHelper.datasetPath(filePath);
		}
	}

}
