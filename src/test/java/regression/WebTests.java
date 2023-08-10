package regression;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.common.ProfilePageBase;
import org.example.gui.pages.desktop.ProfilePage;
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
        HomePageBase homePage = signInPage.signIn("PanPandaHeart","PassyMcPassword123#");

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

    @Test()
    public void deleteTweetTest() {
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

        // Navigate to Profile page
        homePage.navigateToProfilePage();
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.assertPageOpened();

        // Delete tweet
        profilePage.deleteTweet();

    }

}
