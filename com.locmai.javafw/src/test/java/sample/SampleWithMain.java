/**
 * 
 */
package sample;

import java.util.List;

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
		List<String> test = dt.getColumnData("username", "Login_1");
		System.out.println(test.get(0) +  " " + test.get(1));	
	}
}
