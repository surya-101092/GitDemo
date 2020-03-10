package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	private WebDriver driver;
	private Properties property;
	private String direct = System.getProperty("user.dir");

	public WebDriver browserInvocation() throws IOException {

		System.out.println(direct + "\\GlobalFile.properties");
		FileInputStream file = new FileInputStream(direct + "\\GlobalFile.properties");
		property = new Properties();
		property.load(file);
		String browserName = System.getProperty("browser");

		if (browserName.contains("chrome")) {
			// if (property.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", direct + "\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
		} else if (browserName.equals("ie")) {
			// else if(property.getProperty("browser").equals("ie")) {

			driver = new InternetExplorerDriver();
		} else
			driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public void getScreenshots(String result) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(direct + "\\TestResults\\" + result + "screenshot.png"));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProperty() {
		return property;
	}

}
