package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private static final String RATING_SELECT = "//td//select";
    private static final String UPDATE_BUTTON = "//button[@class='button is-primary is-outdlined is-rounded']";
    private static final String SUCCESS_MESSAGE = "//*[contains(text(), 'Post updated')]";
    private static final String TEXT_ENTRY_AREA = "//td[@class='wrap']//textarea[@maxlength='400']";
    private static final String ADD_POST_BUTTON = "//td//*[contains(text(), ' Add ')]";
    private static final int RATING_POSITION = 0;
    private static final String TEXT_FOR_TEXT_ENTRY_AREA = "hello";


    public DashboardPage setupRating(String rating) {
        $$(By.xpath(RATING_SELECT)).get(RATING_POSITION).selectOptionByValue(rating);
        return this;
    }

    public DashboardPage addPostAtTextEntryArea() {
        $$(By.xpath(TEXT_ENTRY_AREA)).get(RATING_POSITION).sendKeys(TEXT_FOR_TEXT_ENTRY_AREA);
        return this;
    }

    public DashboardPage clickToAddPostButton() {
        $$(By.xpath(ADD_POST_BUTTON)).get(RATING_POSITION).click();
        return this;
    }

    public DashboardPage clickUpdateRatingButton() {
        $$(By.xpath(UPDATE_BUTTON)).get(RATING_POSITION).click();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return $(By.xpath(SUCCESS_MESSAGE)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isPostMessageDisplayed(){
        return $(By.xpath(UPDATE_BUTTON)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
