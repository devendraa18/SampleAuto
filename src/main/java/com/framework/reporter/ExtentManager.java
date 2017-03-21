/**
 * 
 */
package com.framework.reporter;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author surendrane
 *
 */
public class ExtentManager {
	
private static ExtentReports extent;
    
    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
            
        }
        
        return extent;
    }
}
