package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import utilities.PathHelper;

public final class DataHelper {
	private Workbook currentWorkbook;
	private Map<String, Sheet> allSheet = new HashMap<String, Sheet>();

	public DataHelper(String filePath) {
		String path = ExcelPathHandler(filePath);
		String fileExtension = path.substring(path.length() - 4);
		addWorkbook(path, fileExtension);
	}

	private void addWorkbook(String path, String fileExtension) {
		try {
			FileInputStream ExcelFile = new FileInputStream(path);

			if (fileExtension.equals("xlsx")) {
				currentWorkbook = new XSSFWorkbook(ExcelFile);

			} else {
				//Got bug here...
				currentWorkbook = new HSSFWorkbook(ExcelFile);
			}
			addAllSheet();
		} catch (Exception e) {
			System.err.println("File not found");
		}
	}

	private void addAllSheet() {
		for (int i = 0; i < currentWorkbook.getNumberOfSheets(); i++) {
			Sheet tmpSheet = currentWorkbook.getSheetAt(i);
			allSheet.put(tmpSheet.getSheetName(), tmpSheet);
		}
	}

	private Sheet getSheet(String sheetName) {
		return allSheet.get(sheetName);
	}
	
	public List<String> getColumnData(int columnIndex, String sheetName) {
		Sheet selectedSheet = getSheet(sheetName);
		List<String> cellData = new ArrayList<String>();
		for (int i = 1; i <= selectedSheet.getLastRowNum(); i++) {
			cellData.add(this.getCellData(i, columnIndex, selectedSheet));
		}
		return cellData;
	}

	public List<String> getColumnData(String headerName, String sheetName) {
		Sheet selectedSheet = getSheet(sheetName);
		return this.getColumnData(this.getColumnIndex(headerName, selectedSheet), selectedSheet.getSheetName());
	}

	public String getCellData(int rowIndex, int columnIndex, Sheet selectedSheet) {
		return this.cellToString(selectedSheet.getRow(rowIndex).getCell(columnIndex));
	}

	private int getColumnIndex(String headerName, Sheet selectedSheet) {
		Row row = selectedSheet.getRow(0);
		int tmpIndex = -1;
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (this.cellToString(cell).equals(headerName)) {
				tmpIndex = cell.getColumnIndex();
				return tmpIndex;
			}
		}
		return tmpIndex;
	}

	private String cellToString(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		return dataFormatter.formatCellValue(cell);
	}

	private static String ExcelPathHandler(String filePath) {
		if (new File(filePath).exists()) {
			return filePath;
		} else {
			return PathHelper.datasetPath(filePath);
		}
	}
}
