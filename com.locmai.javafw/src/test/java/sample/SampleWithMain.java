/**
 * 
 */
package sample;

import enums.*;
import utilities.PathHelper;

/**
 * @author Loc Mai
 *
 */
public class SampleWithMain {

	/**
	 * @param args
	 */
	private final static String driverPath = PathHelper.driverPath(DriverType.CHROME);
	private final static String reportPath = PathHelper.reportPath();
	private final static String logPath = PathHelper.logPath();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(driverPath);
		System.out.println(reportPath);
		System.out.println(logPath);
	}

}
