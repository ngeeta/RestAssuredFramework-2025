package Practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener extends BaseClass implements ITestListener {
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-----onStart------");
		String reportPath=System.getProperty("user.dir")+"//reports/extentReport.html";
		extentSparkReporter=new ExtentSparkReporter(reportPath);
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setDocumentTitle("My sample Report");
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-----onTestStart------");

	}
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		System.out.println("-----onFinish------");

	}
	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS,
				MarkupHelper.createLabel("Test is passed : " + result.getName(), ExtentColor.GREEN));

		System.out.println("----------onTestSuccess----------");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL,
				MarkupHelper.createLabel("Test is Failed : " + result.getName(), ExtentColor.RED));

		System.out.println("-----onTestFailure------");

	}
}
