/**
 * 
 */
package sample;

import helpers.DriverPathHelper;

import enums.*;

/**
 * @author AlvissD
 *
 */
public class SampleWithMain {

	/**
	 * @param args
	 */
	private final static String driverPath = DriverPathHelper.driverPath(DriverType.CHROME);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(driverPath);
	}

}
