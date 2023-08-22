package api.com.util;


import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import api.com.core.BaseTest;

public class ExtentReport extends BaseTest  {

    public static ExtentReports extentreport = null;
    public static ExtentTest extentlog;

    public static void initialize(String path) throws IOException {
        if (extentreport == null) {
            extentreport = new ExtentReports(path, true);
            extentreport.addSystemInfo("Host Name", System.getProperty("user.name"));
            extentreport.addSystemInfo("Environment", Helper.propertyReader("executionEnv"));
            extentreport.addSystemInfo("Build_Version", Helper.propertyReader("build"));
            extentreport.loadConfig(new File(System.getProperty("user.dir") + "/ExtentReports.xml"));
        }
    }
}
