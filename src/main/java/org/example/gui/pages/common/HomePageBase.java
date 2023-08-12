package org.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.gui.pages.components.SideBanner;
import org.example.gui.pages.components.SideBannerBase;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void postTweet(String tweetText);

    public abstract boolean isTweetVisible();

    public abstract SideBannerBase getSideBannerMenu();

    public abstract ProfilePageBase openProfilePage();

    public abstract ProfilePageBase navigateToProfilePage();

}
