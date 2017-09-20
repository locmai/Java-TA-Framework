package utilities;

import java.io.File;
import java.io.FilenameFilter;

import enums.DriverType;

public final class PathHelper {
	public static String driverPath(DriverType driverType) {
		File driverFolder = new File(findFolder("drivers"));
		FilenameFilter driverFilter = new FilenameFilter() {
			public boolean accept(File directory, String fileName) {
				String driverName = driverType.getExecutableFileName();
				return fileName.equals(driverName);
			}
		};
		File[] myDriverPath = driverFolder.listFiles(driverFilter);
		return myDriverPath[0].getPath();
	}

	public static String reportPath() {
		return findFolder("reports");
	}

	public static String logPath() {
		return findFolder("logs");
	}
	
	public static String datasetPath() {
		return findFolder("dataset");
	}
	
	private static String findFolder(String folderName) {
		FilenameFilter fileFilter = new FilenameFilter() {
			public boolean accept(File directory, String fileName) {
				return fileName.equals(folderName);
			}
		};
		final String dir = System.getProperty("user.dir");
		File sourcePath = new File(dir);
		File[] myPath = sourcePath.listFiles(fileFilter);
		return myPath[0].getPath();
	}
}
