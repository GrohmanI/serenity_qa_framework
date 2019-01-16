package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriverAdaptor implements WebDriver {

    private WebElement panel;
    private WebDriver rootPage;

    public WebDriverAdaptor(final WebElement panel, final WebDriver rootPage) {
        this.rootPage = rootPage;
        this.panel = panel;
    }

    @Override
    public void get(final String s) {
        rootPage.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return rootPage.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return rootPage.getTitle();
    }

    @Override
    public List<WebElement> findElements(final By by) {
        return rootPage.findElements(by);
    }

    @Override
    public WebElement findElement(final By by) {
        return rootPage.findElement(by);
    }

    @Override
    public String getPageSource() {
        return rootPage.getPageSource();
    }

    @Override
    public void close() {
        rootPage.close();
    }

    @Override
    public void quit() {
        rootPage.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return rootPage.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return rootPage.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return rootPage.switchTo();
    }

    @Override
    public Navigation navigate() {
        return rootPage.navigate();
    }

    @Override
    public Options manage() {
        return rootPage.manage();
    }
}
