package serenity.steps.sportcheck;

import core.pages.SportcheckMainPage;
import core.panels.ShopMainFooterPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

public  class SportcheckMainPageHelpFulLinksSteps extends ScenarioSteps {

    private SportcheckMainPage sportcheckMainPage;

    public SportcheckMainPageHelpFulLinksSteps(final Pages pages){
        this.sportcheckMainPage = pages.getPage(SportcheckMainPage.class);
    }

    @Step
    public void openPage(String link) {
        sportcheckMainPage.openAt(link);
    }
    @Step
    public void scrollsToEnd() {

        sportcheckMainPage.withAction().sendKeys(Keys.END);

    }
    @Step
    public List<String> getHelpfulLinksList() {
        final ShopMainFooterPanel shopMainFooterPanel = sportcheckMainPage.getShopMainFooterPanel();
        return shopMainFooterPanel.getHelpFulLinksText();
    }
}
