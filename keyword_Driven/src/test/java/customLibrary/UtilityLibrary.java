package customLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UtilityLibrary {

	static WebDriver driver;

	/***
	 * This method is for choosing a browser
	 * 
	 * @param driver
	 * @param locatorType
	 * @param locatorValue
	 * @param data
	 * @return
	 */

	public static String openApplication(WebDriver driver, String URL) {

		try {
			driver.manage().window().maximize();
			driver.get(URL);
			return "pass";

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static String closeApplication(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "pass";
	}

	/***
	 * This method is for typing in textbox;
	 * 
	 * @param driver
	 * @param locatorType
	 * @param locatorValue
	 * @param data
	 * @return
	 */

	public static String typeAction(WebDriver driver, String locatorType, String locatorValue, String data) {
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).sendKeys(data);
			}

			else if (locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			} else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).sendKeys(data);
			}

			else if (locatorType.equalsIgnoreCase("cssSelector")) {
				driver.findElement(By.cssSelector(locatorValue)).sendKeys(data);
			}
			return "pass";
		} catch (Exception e) {

			return e.getMessage();
		}

	}

	public static String ClickAction(WebDriver driver, String locatorType, String locatorValue) {
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).click();
			}

			else if (locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).click();
			} else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).click();
			}

			else if (locatorType.equalsIgnoreCase("cssSelector")) {
				driver.findElement(By.cssSelector(locatorValue)).click();
			}
			return "pass";
		} catch (Exception e) {

			return e.getMessage();
		}

	}

}
