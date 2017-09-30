/**
 * 
 */
package sample;

import enums.*;
import utilities.PathHelper;
import utilities.DataHelper;

/**
 * @author Loc Mai
 *
 */

public class SampleWithMain {

	private final static String driverPath = PathHelper.driverPath(DriverType.CHROME);
	private final static String reportPath = PathHelper.reportPath();
	private final static String logPath = PathHelper.logPath();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(driverPath);
		System.out.println(reportPath);
		System.out.println(logPath);
		DataHelper dt = new DataHelper("dataset1.xlsx");
		// DataHelper.setExcelFile("/home/locmai/Workspace/java/eclipse-workspace/Java-TA-Framework/com.locmai.javafw/dataset/dataset1.xlsx","Login_2");
		// System.out.println(DataHelper.getExcelWSheet().getSheetName());
	}

}
