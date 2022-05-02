package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {
    User user = new User();

    private String rating = "9";
    String expectedTextOfFeedGlobalPage = "Your dashboard";

    @Test(description = "Test for login")
    public void loginTest() {
        feedGlobalPage = loginPage.openPage()
                .login(user);
        Assert.assertEquals(feedGlobalPage.getTextOfFeedGlobalPge(), expectedTextOfFeedGlobalPage, "NOOOOOOOOOOO");
    }

    @Test(description = "Test for add some post at the text area")
    public void addPostTest() {
        dashboardPage = loginPage.openPage()
                .login(user)
                .clickYourDashboardLink()
                .setupRating(rating)
                .addPostAtTextEntryArea()
                .clickToAddPostButton();
        Assert.assertTrue(dashboardPage.isPostMessageDisplayed());
    }

    @Test(description = "Test for update rating of your mood")
    public void moodTest() {
        dashboardPage = loginPage.openPage()
                .login(user)
                .clickYourDashboardLink()
                .setupRating(rating)
                .clickUpdateRatingButton();
        Assert.assertTrue(dashboardPage.isSuccessMessageDisplayed());

    }
}
