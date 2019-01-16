package serenity.steps.rozetka;

import core.pages.RozetkaMainPage;
import core.panels.RozetkaContentPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class RozetkaPageSteps extends ScenarioSteps {

    private RozetkaMainPage rozetkaMainPage;

    public RozetkaPageSteps(final Pages pages) {
        this.rozetkaMainPage = pages.getPage(RozetkaMainPage.class);
    }

    @Step
    public void openRozetkaPage(final String siteUrl) {

        rozetkaMainPage.openAt(siteUrl);
    }

    @Step
    public void typeInputWord(final String searchWord) {
        rozetkaMainPage.getHeaderPanel().typeTextToSearch(searchWord);
    }

    @Step
    public void clickFirstGoods() {
        rozetkaMainPage.getContentPanel().clickFirstGoodLink();
    }

    @Step
    public void clickButtonWishList() {
        rozetkaMainPage.getContentPanel().clickButtonToWishList();
    }

    @Step
    public void closePopup() {
        rozetkaMainPage.getHeaderPanel().closePopup();
    }

    @Step
    public void typeFakeEmail() {
        rozetkaMainPage.getHeaderPanel().registrationForm("aduboviyyyyyyf@gmail.com");
    }

    @Step
    public void clickButtonSave() {
        rozetkaMainPage.getHeaderPanel().clickToSave();
    }

    @Step
    public void typeFakeFio() {
        rozetkaMainPage.getHeaderPanel().setInputToFio("duboyviy andreyyyyyy");
    }

    @Step
    public void clickOpenWishList() {
        rozetkaMainPage.getHeaderPanel().openWishList();
    }

    @Step
    public void closePopup2() {
        rozetkaMainPage.getHeaderPanel().closePopup2();
    }
    @Step
    public List<String> getWishListItems(){
        final RozetkaContentPanel rozetkaContentPanel = rozetkaMainPage.getContentPanel();
        return rozetkaContentPanel.getWishListText();
    }
}
