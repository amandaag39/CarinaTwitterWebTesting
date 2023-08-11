package org.example.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(css = "a[aria-label='Twitter']")
    private ExtendedWebElement homePageLogo;

    @FindBy(css = "div.public-DraftStyleDefault-block")
    private ExtendedWebElement tweetTextField;

    @FindBy(css = "div[data-testid='tweetButtonInline']")
    private ExtendedWebElement tweetButton;

    @FindBy(xpath = "//span[text()='@PanPandaHeart']")
    private ExtendedWebElement userTweetHandle;

    @FindBy(css = "a[aria-label='Profile']")
    private ExtendedWebElement navigateToProfilePageButton;



    public HomePage(WebDriver driver) {
        super(driver);
        this.setPageURL("/home");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void postTweet(String tweetText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.public-DraftStyleDefault-block"))).click();
        tweetTextField.type(tweetText);
        tweetButton.click();
    }

    @Override
    public boolean isTweetVisible() {
        return userTweetHandle.isPresent();
    }

    public ProfilePageBase navigateToProfilePage() {
        navigateToProfilePageButton.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }
}
