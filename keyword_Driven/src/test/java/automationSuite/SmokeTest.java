package automationSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import customLibrary.UtilityLibrary;
import dataProvider.ExcelDataProvider;

public class SmokeTest {
	WebDriver driver;

	@Test
	public void testToolQA() {

		ExcelDataProvider excel = new ExcelDataProvider();

		int rowCount = excel.rowCount("SignUpForm");

		for (int i = 1; i < rowCount; i++) {
			String description = excel.getData("SignUpForm", i, 0);
			String object_Type = excel.getData("SignUpForm", i, 1);
			String actions = excel.getData("SignUpForm", i, 2);
			String locator_Type = excel.getData("SignUpForm", i, 3);
			String locator_Value = excel.getData("SignUpForm", i, 4);
			String testData = excel.getData("SignUpForm", i, 5);

			if (object_Type.equalsIgnoreCase("browser"))

			{
				if (testData.equalsIgnoreCase("chrome"))

				{
					if (actions.equalsIgnoreCase("startBrowser"))

					{
						System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
						driver = new ChromeDriver();

					}
					if (actions.equalsIgnoreCase("closeBrowser"))

					{
						driver.quit();
					}
				}
				if (testData.equalsIgnoreCase("firefox"))

				{
					if (actions.equalsIgnoreCase("startBrowser"))

					{
						System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
						driver = new ChromeDriver();

					}
				
				}	if (actions.equalsIgnoreCase("closeBrowser"))

				{
					driver.quit();
				}

			}

			if (object_Type.equalsIgnoreCase("OpenApp"))

			{
				if (actions.equalsIgnoreCase("navigate"))

				{
					UtilityLibrary.openApplication(driver, testData);
				}
			}
			if (object_Type.equalsIgnoreCase("typeText"))

			{
				UtilityLibrary.typeAction(driver, locator_Type, locator_Value, testData);
			}

			if (object_Type.equalsIgnoreCase("click"))

			{
				UtilityLibrary.ClickAction(driver, locator_Type, locator_Value);
			}
		}

	}
}
