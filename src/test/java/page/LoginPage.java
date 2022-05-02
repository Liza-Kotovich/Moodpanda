package page;

import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public static final String LOGIN_URL = "https://moodpanda.com/login";
    public static final String EMAIL_INPUT = "//input[@placeholder='MoodPanda registered email ']\n";
    public static final String PASSWORD_INPUT = "//input[@name='password']\n";
    public static final String LOGIN_BUTTON = "//button[@class='button is-vcentered is-danger is-rounded is-fullwidth is-oudtlined']";

    public LoginPage openPage() {
        open(LOGIN_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        $(By.xpath(LOGIN_BUTTON)).click();
    }

    public FeedGlobalPage login(User user) {
        enterEmail(user.getUserEmail());
        enterPassword(user.getUserPassword());
        clickLoginButton();
        return new FeedGlobalPage();
    }
}
