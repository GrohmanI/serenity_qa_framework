package core.pages;

import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends AbstractPage {

    private static final String SEARCH_INPUT = "//input[@name='q']";

    public GoogleMainPage(final WebDriver driver) {
        super(driver);
    }

    public String getCurrentTitle() {
        return getTitle();
    }

    public void typeSearchText(final String text) {
        findBy(SEARCH_INPUT).then().type(text);
    }
}
