package pageojectsrepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='sign_in']")
	private WebElement signIn;

	@FindBy(xpath = "//section[@id='content']/div/div/h2")
	private WebElement title;

	@FindBy(css = "ul[class*='nav navbar-nav']>li:nth-child(3)")
	private WebElement videosTitle;
	@FindBy(css="div[class='carousel-caption']>div>div>h3")
    private WebElement banner;
	
	public WebElement signIn() {
		return signIn;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getVideosTitle() {
		return videosTitle;
	}

	public WebElement getBanner() {
		return banner;
	}
}
