package core.pages;

import core.panels.TranslatePanel;
import org.openqa.selenium.WebDriver;

public class GoogleTranslatePage extends AbstractPage {

    private static final String TRANSLATE_PANEL = "//div[@class='homepage-content-wrap']";

    public GoogleTranslatePage(final WebDriver driver) {
        super(driver);
    }

    public TranslatePanel getTranslatePanel() {
        return new TranslatePanel(findBy(TRANSLATE_PANEL), this);
    }
}
