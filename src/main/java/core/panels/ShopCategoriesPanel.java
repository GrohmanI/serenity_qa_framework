package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ShopCategoriesPanel extends AbstractPanel {

    private static final String CATEGORIES = ".//span[@class='main-menu__text']";

    public ShopCategoriesPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }

    public List<String> getCategoriesText() {
        final List<WebElementFacade> shopCategoriesItems = getRootPage().findAll(CATEGORIES);
        return shopCategoriesItems.stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

}
