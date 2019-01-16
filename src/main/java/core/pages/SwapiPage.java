package core.pages;

import org.openqa.selenium.WebDriver;

public class SwapiPage extends AbstractPage {


    private static final String SEARCH_INPUT = "//input[@name='q']";

    public SwapiPage(final WebDriver driver) {
        super(driver);
    }

    public String getCurrentTitle() {
        return getTitle();
    }

    public void typeSearchText(final String text) {
        findBy(SEARCH_INPUT).then().type(text);
    }
}

