package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedGlobalPage {

    public static final String YOUR_DASHBOARD_LINK = "//*[contains(text(), ' Your dashboard')]";

    public DashboardPage clickYourDashboardLink() {
        $(By.xpath(YOUR_DASHBOARD_LINK)).click();
        return new DashboardPage();
    }

    public String getTextOfFeedGlobalPge() {
        return $(By.xpath(YOUR_DASHBOARD_LINK)).getText();
    }
}
