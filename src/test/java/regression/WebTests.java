package regression;

import com.sun.xml.bind.v2.TODO;
import com.zebrunner.carina.core.IAbstractTest;
import org.example.gui.pages.common.HomePageBase;
import org.example.gui.pages.desktop.ProfilePage;
import org.example.gui.pages.desktop.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTests implements IAbstractTest {

    @BeforeMethod(onlyForGroups = {"SignInRequired"})
    public void beforeMethod() {
        // Open sign-in page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();

        // Perform sign-in with valid credentials
        HomePageBase homePage = signInPage.signIn();

        //Verify Home Page is opened
        homePage.assertPageOpened();
    }

    @Test (testName = "Open Sign In Page", description = "Testing successful launch of Sign In Page")
    public void openSignInPage() {
        // Open login page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();
    }

    @Test(testName = "Sign In", description = "Testing the sign in feature from the sign in screen")
    public void signInTest() {
        // Open sign-in page and verify page is opened
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.assertPageOpened();

        // Perform sign-in with valid credentials
        HomePageBase homePage = signInPage.signIn();

        //Verify Home Page is opened
        homePage.assertPageOpened();
    }

    @Test(testName = "Post a Tweet", groups = {"SignInRequired"}, description = "Testing for successful posting of a tweet from home page")
    public void postTweetTest() {
        // Post "Hello, World!" tweet
        String tweetText = " Hello, World!";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.postTweet(tweetText);

        // Check if tweet is posted
        Assert.assertTrue(homePage.isTweetVisible(), "Tweet was not posted successfully");
    }

    @Test(testName = "Delete a Tweet", groups = {"SignInRequired"}, description = "Testing for successful deletion of tweet from profile page")
    public void deleteTweetTest() {
        // Post "Hello, World!" tweet
        String tweetText = " Hello, World!";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.postTweet(tweetText);

        // Check if tweet is posted
        Assert.assertTrue(homePage.isTweetVisible(), "Tweet was not posted successfully");

        // Navigate to Profile page
        homePage.navigateToProfilePage();
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.assertPageOpened();

        // Delete tweet
        profilePage.deleteTweet();

        // Validate deletion TODO: Add method to validate deletion after finding best locator

    }

}
