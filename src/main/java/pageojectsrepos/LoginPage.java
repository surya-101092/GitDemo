package pageojectsrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement email;

	@FindBy(name = "user[password]")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginBtn;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement loginButton() {
		return loginBtn;
	}
}
