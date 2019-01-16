package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ShopMainFooterPanel extends AbstractPanel {
    private static final String HELP_FULL_LINKS = "(//div[@data-module-type = 'HelpfulLinks'])[2]//a[not(contains(@style,'display'))]";

    public ShopMainFooterPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }

    public List<String> getHelpFulLinksText() {
        final List<WebElementFacade> shopCategoriesItems = getRootPage().findAll(HELP_FULL_LINKS);
        return shopCategoriesItems.stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

}
