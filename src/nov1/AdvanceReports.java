package nov1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
ExtentReports report;
ExtentTest test;
WebDriver driver;
String expected ="";
String actual="";
@BeforeTest
public void generateReport()
{
	report = new ExtentReports("./ExtentReports/Demo.html");
	
}
@BeforeMethod
public void setUp()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com");
}
@Test
public void passtest()
{
test =report.startTest("Test Pass");
test.assignAuthor("Ranga");
	expected ="Google";
	actual =driver.getTitle();
	if(expected.equalsIgnoreCase(actual))
	{
		test.log(LogStatus.PASS, "My Test Case pass::"+expected+"     "+actual);
		Reporter.log("Title Matching");
	}
	else
	{
		test.log(LogStatus.FAIL, "My Test Case Fail::"+expected+"     "+actual);
		Reporter.log("Title not Matching");
	}
}
@Test
public void failTest()
{
	test =report.startTest("Test Fail");
	test.assignAuthor("Ranga");
		expected ="Gmail";
		actual =driver.getTitle();
		if(expected.equalsIgnoreCase(actual))
		{
			test.log(LogStatus.PASS, "My Test Case pass::"+expected+"     "+actual);
			Reporter.log("Title Matching");
		}
		else
		{
			test.log(LogStatus.FAIL, "My Test Case Fail::"+expected+"     "+actual);
			Reporter.log("Title not Matching");
		}
}
@AfterMethod
public void tearDown()
{
report.endTest(test);
report.flush();
driver.close();
}
}
