package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class CNNHeaderPanel extends AbstractPanel {
    private static final String SEARCH_BUTTON = "//div[@id='search-button']";
    private static final String INPUT_SEARCH = "//input[@class='search__input-field']";

    public CNNHeaderPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }
    public void clickSearchButton (){
        getRootPage().findBy(SEARCH_BUTTON).waitUntilVisible().then().click();
    }
    public void typeTextToSearch(final String text) {

        getRootPage().findBy(INPUT_SEARCH).waitUntilVisible().then().type(text).sendKeys(Keys.ENTER);
    }

}
