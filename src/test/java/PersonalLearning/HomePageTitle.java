package PersonalLearning;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageojectsrepos.LandingPage;
import resources.Base;

public class HomePageTitle extends Base {

	private static Logger log = LogManager.getLogger(HomePageTitle.class.getName());
	WebDriver driver = getDriver();

	@BeforeTest
	public void initialize() throws IOException {
		driver = browserInvocation();
		log.info("Driver is initialized");
		driver.get(getProperty().getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void homePageTitle() {
		LandingPage land = new LandingPage(driver);
		Assert.assertEquals(land.getTitle().getText(), "FEATURED COURSES");
		System.out.println(land.getVideosTitle().getText());
		Assert.assertTrue(land.getVideosTitle().isDisplayed());
		Assert.assertTrue(land.getVideosTitle().getText().contains("VIDEOS"));
		log.info("Videos text is displayed");
		System.out.println("Hellow GIT Master");

	}

	@Test
	public void bannerValidation() {
		LandingPage land = new LandingPage(driver);
		Assert.assertEquals(land.getBanner().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Banner is displayed as per test");
		System.out.println("Hellow GIT Master");
		
		System.out.println("Hellow GIT Master");
		System.out.println("Hellow GIT Master");
		System.out.println("Hellow GIT Master");
		System.out.println("Hellow GIT Master");
		
	}

	@AfterTest
	public void browserClose() {
		driver.close();
		driver = null;
	}

}
