package org.example.gui.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.common.SignInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(css = "input[autocomplete='username']")
    private ExtendedWebElement usernameField;

    @FindBy(css = "div[data-viewportview='true'] div[data-testid='apple_sign_in_button'] + div + div + div[role='button']")
    private ExtendedWebElement nextButton;

    @FindBy(css = "input[type='password']")
    private ExtendedWebElement passwordField;

    @FindBy(css = "div[data-testid='LoginForm_Footer_Container'] div[role='button']")
    private ExtendedWebElement loginButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.setPageURL("/i/flow/login");
        setPageOpeningStrategy((PageOpeningStrategy.BY_ELEMENT));
        setUiLoadedMarker(usernameField);
    }

    @Override
    public HomePageBase signIn(String username, String password) {
        usernameField.type(username);
        nextButton.click();
        passwordField.type(password);
        loginButton.click();

        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return initPage(driver, HomePageBase.class);
    }
}
