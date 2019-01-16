package serenity.steps.google;

import core.pages.GoogleMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class GooglePageSteps extends ScenarioSteps {

    private GoogleMainPage googleMainPage;

    public GooglePageSteps(final Pages pages) {
        googleMainPage = pages.getPage(GoogleMainPage.class);
    }

    @Step
    public String getOpenedPageTitle() {
        return googleMainPage.getCurrentTitle();
    }

    @Step
    public void typeSearchText(final String text) {
        googleMainPage.typeSearchText(text);
    }

    @Step
    public void openGooglePage(final String link) {
        googleMainPage.openAt(link);
    }
}
