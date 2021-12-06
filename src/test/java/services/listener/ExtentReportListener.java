package services.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;

import lombok.var;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import services.FluentWaitCode;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportListener extends FluentWaitCode {
	String fileName = reportLocation + "extentreport.html";


	public synchronized ExtentReports ExtentReport() {
		//First is to create Extent Reports
		extent = new ExtentReports();

		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/java/reports/Extent.html");
		spark.config().setDocumentTitle("BV Parallel Selenium BDD");
		spark.config().setReportName("BACH QA");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		return extent;

	}




	public void FlushReport(){
		extent.flush();
	}



}