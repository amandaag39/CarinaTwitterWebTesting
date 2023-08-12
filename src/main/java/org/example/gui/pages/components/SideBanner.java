package org.example.gui.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.gui.pages.common.ProfilePageBase;
import org.example.gui.pages.desktop.ProfilePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideBanner extends SideBannerBase{
    @FindBy(xpath = "//a[@aria-label='Twitter']")
    private ExtendedWebElement twitterLogoHomeButton;

    @FindBy(xpath = "//a[@aria-label='Home']")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//a[@aria-label='Search and explore']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//a[@aria-label='Notifications']")
    private ExtendedWebElement notificationsButton;

    @FindBy(xpath = "//a[@aria-label='Direct Messages']")
    private ExtendedWebElement messagesButton;

    @FindBy(xpath = "//a[@aria-label='Lists']")
    private ExtendedWebElement listsButton;

    @FindBy (xpath = "//a[@aria-label='Bookmarks']")
    private ExtendedWebElement bookmarksButton;

    @FindBy (xpath = "//a[@aria-label='Communities']")
    private ExtendedWebElement communitiesButton;

    @FindBy (xpath = "//a[@aria-label='Verified']")
    private ExtendedWebElement verifiedButton;

    @FindBy (xpath = "//a[@aria-label='Profile']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//div[@aria-label='More menu items']")
    private ExtendedWebElement moreMenuItemsButton;

    @FindBy(xpath = "//a[@aria-label='Post']")
    private ExtendedWebElement postTweetButton;

    @FindBy(xpath = "//div[@aria-label='Account menu']")
    private ExtendedWebElement accountMenuButton;

    public SideBanner(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProfilePage openProfilePage() {
        profileButton.click();
        return new ProfilePage(driver);
    }
}
