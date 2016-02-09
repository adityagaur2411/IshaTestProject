package com.test;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstWebDriver {

	RemoteWebDriver remoteDriver = null;
	WebDriver localDriver = null;
	Object wb = null;
	String remoteExecFlag = null;

	@Before
	public void setUp() throws Exception {
		
		ReadExcelFile objReadxl = new ReadExcelFile();
		wb = objReadxl.openExcel("E:/isha_selenium/BrowserConfig.xlsx");
		remoteExecFlag = (String) objReadxl.getFieldValue("BrowserConfig", "", "Remote Execution");		
		
		ExecutionType execType = new ExecutionType();
		execType.setExecutionType(remoteExecFlag);
		 
	}

	@Test
	public void myFirstTest() throws Exception {

		BrowserToExecute brw = new BrowserToExecute();
		List<String> browsers = brw.getBrowser(wb, "BrowserConfig");
		
		switch (remoteExecFlag.toLowerCase()) {
		case "yes":
			for (String br : browsers) {
				GetDesiredDriver dr = new GetDesiredDriver();
				remoteDriver = (RemoteWebDriver) dr.getRemoteDriver(br);
				remoteDriver.get("https://google.com");
				remoteDriver.quit();
			}
			break;
			
		case "no" :
			for (String br : browsers) {
				GetDesiredDriver dr = new GetDesiredDriver();
				localDriver = (WebDriver) dr.getLocalDriver(br);
				localDriver.get("https://google.com");
				localDriver.quit();
			}
			break;

		default:
			break;
		}
		

		

		/*
		 * ReadExcelFile readExcelObject = new ReadExcelFile();
		 * readExcelObject.openExcel("E:/isha_selenium/TestInput.xlsx"); Object
		 * value = readExcelObject.getFieldValue("TestData", "BrowserType",
		 * "Yes");
		 */


		/*
		 * driver2.findElement(By.name("q")).sendKeys("Isha");
		 * driver2.findElement(By.name("btnG")).click(); WebElement value =
		 * driver2.findElement(By.cssSelector("div.kno-ecr-pt.kno-fb-ctx"));
		 * System.out.println(value.getText());
		 * 
		 * Assert.assertTrue("Match failed", value.getText().equalsIgnoreCase(
		 * "Isha Foundation")); // Assert.assertEquals(value.getText(),
		 * "Isha Foundation"); // driver.quit();
		 */
		

	}

	/*
	 * @After public void Terminate() throws Exception {
	 * 
	 * //Runtime rtHub = Runtime.getRuntime(); //rtHub.exec("cmd /C start /min "
	 * + "E:/hub.bat"); Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	 * Thread.sleep(5000);; //Runtime rtNode = Runtime.getRuntime();
	 * //rtNode.exec("cmd /C start /min "+ "E:/node.bat");
	 * //Runtime.getRuntime().exec("E:/node.bat");
	 * 
	 * //this.localhost = GetHubDetails.getIP();
	 * 
	 * }
	 */

}
