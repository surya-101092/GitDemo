package PersonalLearning;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageojectsrepos.LandingPage;
import pageojectsrepos.LoginPage;
import resources.Base;

public class HomePage extends Base {
	WebDriver driver = getDriver();

	@BeforeMethod
	public void initialize() throws IOException {

		driver = browserInvocation();
		driver.get(getProperty().getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password) {

		LandingPage land = new LandingPage(driver);
		land.signIn().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.loginButton().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object data1[][] = new Object[][] { { "abc@gmail.com", "hello@123" }, { "pqr@gmail.com", "anc@rkf" } };
		return data1;

	}

	@AfterMethod
	public void browserClose() {
		driver.close();
	}
}
