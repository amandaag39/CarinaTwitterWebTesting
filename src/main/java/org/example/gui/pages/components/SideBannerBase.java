package org.example.gui.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.example.gui.pages.desktop.ProfilePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SideBannerBase extends AbstractUIObject {
    protected SideBannerBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProfilePage openProfilePage();
}
