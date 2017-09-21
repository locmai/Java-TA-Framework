package utilities;

import java.io.File;
import java.io.FilenameFilter;

import enums.DriverType;

public final class PathHelper {
	private final static String sourceDir = System.getProperty("user.dir");

	public static String driverPath(DriverType driverType) {
		File driverFolder = new File(findFile(sourceDir, "drivers"));
		File driverPath = new File(findFile(driverFolder.getPath(), driverType.getExecutableFileName()));
		return driverPath.getPath();
	}

	public static String reportPath() {
		return findFile(sourceDir, "reports");
	}

	public static String logPath() {
		return findFile(sourceDir, "logs");
	}

	public static String datasetPath() {
		return findFile(sourceDir, "dataset");
	}

	public static String datasetPath(String fileName) {
		return findFile(datasetPath(), fileName);
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
