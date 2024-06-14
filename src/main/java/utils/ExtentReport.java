package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static void main(String[] args) throws Exception{
	 ExtentReports extentReport = new ExtentReports();
	 ExtentSparkReporter extentSpartReporter = new ExtentSparkReporter("report.html");
	 
	 //ExtentTest test1 = extentReport.createTest("Extent Pass");
	 //test1.pass("Test 1 passed");
	 
	 //ExtentTest test2 = extentReport.createTest("Test2");
	 //test2.log(Status.FAIL, "THis is failed");
	 
	 //extentReport.attachReporter(extentSpartReporter);
	 //extentReport.flush();
	}
}
