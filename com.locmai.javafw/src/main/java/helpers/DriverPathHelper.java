package helpers;

import java.io.File;
import java.io.FilenameFilter;

import enums.DriverType;

public final class DriverPathHelper {
	public static String driverPath(DriverType driverType) {
		
		FilenameFilter fileFilter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	            return fileName.equals("drivers");
	        }
		};
		final String dir = System.getProperty("user.dir");
		File sourcePath = new File(dir);
		File[] myDriverFolder = sourcePath.listFiles(fileFilter);
		
		FilenameFilter driverFilter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	            String driverName = driverType.getExecutableFileName();
	        	return fileName.equals(driverName);
	        }
		};
		
		File[] myDriverPath = myDriverFolder[0].listFiles(driverFilter);
		
		return myDriverPath[0].getPath();
	}

}
