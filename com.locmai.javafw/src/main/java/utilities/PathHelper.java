package utilities;

import java.io.File;
import java.io.FilenameFilter;

import enums.DriverType;

public final class PathHelper {
	private final static String SOURCE_DIR = System.getProperty("user.dir");

	public static String driverPath(DriverType driverType) {
		File driverFolder = new File(findFile(SOURCE_DIR, "drivers"));
		File driverPath = new File(findFile(driverFolder.getPath(), driverType.getExecutableFileName()));
		return driverPath.getPath();
	}

	public static String reportPath() {
		return findFile(SOURCE_DIR, "reports");
	}

	public static String logPath() {
		return findFile(SOURCE_DIR, "logs");
	}

	public static String datasetPath() {
		return findFile(SOURCE_DIR, "dataset");
	}

	public static String datasetPath(String fileName) {
		return findFile(datasetPath(), fileName);
	}

	public static String createFile(String dirName,String fileName) {
		return findFile(SOURCE_DIR,dirName) + File.separator + fileName ;
	}
	
	private static String findFile(String parentDir, String folderName) {

		FilenameFilter fileFilter = new FilenameFilter() {
			public boolean accept(File directory, String fileName) {
				return fileName.equals(folderName);
			}
		};

		File sourcePath = new File(parentDir);
		File[] myPath = sourcePath.listFiles(fileFilter);
		return myPath[0].getPath();
	}
}
