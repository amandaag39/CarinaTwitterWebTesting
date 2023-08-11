package org.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void postTweet(String tweetText);

    public abstract boolean isTweetVisible();

    public abstract ProfilePageBase navigateToProfilePage();

}
