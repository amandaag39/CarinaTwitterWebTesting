package org.example.gui.pages.desktop;

import com.amazonaws.auth.profile.internal.Profile;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(css = "article[data-testid='tweet'] div[data-testid='caret']")
    private ExtendedWebElement tweetMoreOptionButton;

    @FindBy(css = "div[data-testid='Dropdown'] > div:first-child > div:nth-child(2)")
    private ExtendedWebElement dropdownDeleteTweetButton;

    @FindBy(css = "div[data-testid='confirmationSheetDialog'] > div:nth-child(3) > div:first-child > div:first-child")
    private ExtendedWebElement dialogueBoxDeleteButton;

    @FindBy(xpath = "//span[text()='Your Tweet was deleted']")
    private ExtendedWebElement popUpTweetDeletedConfirmation;


    public ProfilePage(WebDriver driver) {
        super(driver);
        this.setPageURL("/PanPandaHeart");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void deleteTweet() {
        tweetMoreOptionButton.click();
        dropdownDeleteTweetButton.click();
        dialogueBoxDeleteButton.click();
    }

    public boolean confirmTweetDeleted() {
        return popUpTweetDeletedConfirmation.isPresent();
    }

}
