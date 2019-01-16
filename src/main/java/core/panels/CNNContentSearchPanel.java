package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class CNNContentSearchPanel extends AbstractPanel {
    private static final String ALL_DISPLAYED_RESULTS = "//div[@class='cnn-search__results-list']/div";

    public CNNContentSearchPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }



}
