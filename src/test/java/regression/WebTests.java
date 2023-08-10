package regression;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.desktop.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests implements IAbstractTest {

    @Test
    public void openSignInPage() {
        // Open login page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();
    }

    @Test
    public void signInTest() {
        // Open sign-in page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();

        // Perform sign-in with valid credentials
        HomePageBase homePage = signInPage.signIn("PanPandaHeart","Pwnage4625196!");

        //Verify Home Page is opened
        homePage.assertPageOpened();
    }

    @Test
    public void postTweetTest() {
        // Open sign-in page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();

        // Perform sign-in with valid credentials
        HomePageBase homePage = signInPage.signIn("PanPandaHeart","PassyMcPassword123#");

        //Verify Home Page is opened
        homePage.assertPageOpened();

        // Post "Hello, World!" tweet
        String tweetText = " Hello, World!";
        homePage.postTweet(tweetText);

        // Check if tweet is posted
        Assert.assertTrue(homePage.isTweetVisible(), "Tweet was not posted successfully");
    }


}
