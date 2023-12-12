package slbasereport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
public class BaseTest {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;
    public static String ApkUrl;

    public void StartReport() {
        ApkUrl = "D:\\FenilIT\\AndroidTesting\\smartLearn(test).apk";
        htmlReporter = new ExtentSparkReporter("ExtentSmartLearnMobileAppReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        // Add environment details
        reports.setSystemInfo("Machine", "DELL");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("User", "Administrator");
        reports.setSystemInfo("Browser", "Firefox");
        // configuration to change look and feel
        htmlReporter.config().setDocumentTitle("Extent Smart Learn Admin Portal Report");
        htmlReporter.config().setReportName("SmartLearn Admin Portal TestCases Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @AfterMethod
    public void getTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAIL", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(convertNewlineToBr(result.getThrowable() + "FAIL"), ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getStatus() + "FAIL", ExtentColor.RED));

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASS", ExtentColor.GREEN));
            test.log(Status.PASS, MarkupHelper.createLabel(result.getStatus() + "PASS", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getTestName() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getStatus() + "SKIPPED", ExtentColor.YELLOW));
        }
    }
    private static String convertNewlineToBr(String message) {
        // Convert newline characters to HTML <br/> tags
        return message.replaceAll("\n", "<br/>");
    }
    @AfterSuite
    public void tearDown() {
        reports.flush();
    }

    public static String takingScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String fileName = "IMG" + timestamp + ".png";
        FileUtils.copyFile(scrFile, new File("./TestcasesScreenshot/screenshots" + fileName));
        return fileName;
    }
    public static int countSelectedCheckboxes(List<WebElement> checkboxes) {
        int count = 0;
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                count++;
            }
        }
        return count;
    }
    public static String generateRandomMobileNumber() {
        // Generate a random 10-digit mobile number
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("9"); // Assuming the mobile number starts with 9

        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10));
        }

        return mobileNumber.toString();
    }


}

