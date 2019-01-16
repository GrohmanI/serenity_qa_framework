package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaContentPanel extends AbstractPanel {

    private static final String GOODS = "(//div[@class ='rz-goods-main-content clearfix'])//div[@class='g-i-tile-i-title clearfix']";
    private static final String BUTTON_TO_WITH_LIST = "//a[@name= 'towishlist']";
    private static final String ELEMENT_WISHBLOCK ="//div[@name='wishlist-block-goods']";

    public RozetkaContentPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }
    public void clickFirstGoodLink() {
        getRootPage().findAll(GOODS).get(0).waitUntilVisible().click();
    }
    public void clickButtonToWishList (){
        getRootPage().findBy(BUTTON_TO_WITH_LIST).waitUntilVisible().then().click();
    }
    public List<String> getWishListText() {
        final List<WebElementFacade> getWishListItem = getRootPage().findAll(ELEMENT_WISHBLOCK);
        return getWishListItem.stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }





}
