package core.panels;

import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class TranslatePanel extends AbstractPanel {

    private static final String SOURCE_LANGUAGE = ".//div[@class='sl-wrap']//div[text()='%s']";
    private static final String TARGET_LANGUAGE = ".//div[@class='tl-wrap']//div[text()='%s']";
    private static final String INPUT_TEXT_AREA = ".//textarea[@id='source']";
    private static final String TARGET_TEXT_AREA = ".//span[contains(@class,'tlid-translation translation')]//span";

    public TranslatePanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }

    public void selectSourceLanguage(final String language) {
        selectRequiredParameter(SOURCE_LANGUAGE, language);
    }

    public void selectTargetLanguage(final String language) {
        selectRequiredParameter(TARGET_LANGUAGE, language);
    }

    public void typeTextToTranslate(final String text) {
        getRootPage().findBy(INPUT_TEXT_AREA).then().type(text);
    }

    public String getTranslatedText() {
        return getRootPage().findBy(TARGET_TEXT_AREA).then().getText();
    }

    private void selectRequiredParameter(final String shortPath, final String language) {
        final String languageAlreadySelectedCondition = "jfk-button-checked";
        final String fullPath = String.format(shortPath, language);
        final WebElementFacade languageToBeClickable = getRootPage().findBy(fullPath);
        if (!languageToBeClickable.getAttribute("class").contains(languageAlreadySelectedCondition)) {
            languageToBeClickable.then().click();
        }
    }
}
