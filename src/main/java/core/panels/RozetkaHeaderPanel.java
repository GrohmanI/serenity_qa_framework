package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class RozetkaHeaderPanel extends AbstractPanel {

    private static final String INPUT_SEARCH = "//input[@name='search']";////input[@name='search']   //input[@class='rz-header-search-input-text passive']

    private static final String INPUT_TO_FIRST_MAIL = "(//input[@class= 'input-text wishlists-i-input'])[2]";
    private static final String BUTTON_TO_SAVE = "(//button[@type= 'submit'])[1]";
    private static final String INPUT_TO_FIO = "//input[@name= 'fio']";
    //AND SECOND SAVE
    private static final String CLOSE_POPUP = "//a[@class='confirm-email-popup-i-close novisited']";
    private static final String BUTTON_WISH_LIST = "//a[@class='hub-i-link hub-i-wishlist-link-count sprite-side whitelink']";
    private static final String CLOSE_POPUP2 ="//a[@class='social-bind-tiny-close novisited']";


    public RozetkaHeaderPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }


    public void typeTextToSearch(final String text) {

        getRootPage().findBy(INPUT_SEARCH).waitUntilVisible().then().type(text).sendKeys(Keys.ENTER);
    }


    public void registrationForm(final String mail){
        getRootPage().findBy(INPUT_TO_FIRST_MAIL).waitUntilVisible().then().type(mail);
    }
    public void clickToSave(){
        getRootPage().findBy(BUTTON_TO_SAVE).waitUntilVisible().then().click();
    }
    public void setInputToFio(final String fio){
        getRootPage().findBy(INPUT_TO_FIO).waitUntilVisible().then().type(fio);
    }

    public void closePopup(){
        getRootPage().findBy(CLOSE_POPUP).waitUntilVisible().then().click();
    }
    public void openWishList(){
        getRootPage().findBy(BUTTON_WISH_LIST).waitUntilVisible().then().click();
    }
    public void closePopup2(){
        getRootPage().findBy(CLOSE_POPUP2).waitUntilVisible().then().click();
    }

}
