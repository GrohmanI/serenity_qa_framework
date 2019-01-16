package core.panels;

import core.WebDriverAdaptor;
import core.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.SmartElementLocatorFactory;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public abstract class AbstractPanel {

    private long waitForTimeoutInMilliseconds;
    private AbstractPage rootPage;
    private WebDriverAdaptor panelLocator;

    public AbstractPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        this.rootPage = rootPage;
        this.waitForTimeoutInMilliseconds = rootPage.waitForTimeoutInMilliseconds();
        this.panelLocator = new WebDriverAdaptor(panelLocator, rootPage.getDriver());
        initPanel();
    }

    public AbstractPage getRootPage() {
        return rootPage;
    }

    private void initPanel() {
        final ElementLocatorFactory finder = new SmartElementLocatorFactory(panelLocator, null, (int) waitForTimeoutInMilliseconds);
        final FieldDecorator decorator = new SmartFieldDecorator(finder, rootPage.getDriver(), rootPage);
        PageFactory.initElements(decorator, this);
    }
}
