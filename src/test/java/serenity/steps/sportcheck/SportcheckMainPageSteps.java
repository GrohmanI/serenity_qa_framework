package serenity.steps.sportcheck;

import core.pages.SportcheckMainPage;
import core.panels.ShopCategoriesPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SportcheckMainPageSteps extends ScenarioSteps {

    private SportcheckMainPage sportcheckMainPage;

    public SportcheckMainPageSteps(final Pages pages){
        this.sportcheckMainPage = pages.getPage(SportcheckMainPage.class);
    }

    @Step
    public void openPage(final String link) {
        sportcheckMainPage.openAt(link);

    }

    @Step
    public void expandShopCategoriesList() {
       sportcheckMainPage.expandShopCategoriesPanel();

    }

    @Step
    public List<String> getShopCategoriesList() {
        final ShopCategoriesPanel shopCategoriesPanel = sportcheckMainPage.getShopCategoriesPanel();
        return shopCategoriesPanel.getCategoriesText();

    }
}
