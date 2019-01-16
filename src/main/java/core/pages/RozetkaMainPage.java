package core.pages;

import core.panels.RozetkaContentPanel;
import core.panels.RozetkaHeaderPanel;
import org.openqa.selenium.WebDriver;

public class RozetkaMainPage extends AbstractPage {


    private static final String HEADER_PANEL = "//header[@id ='body-header']";
    private static final String CONTENT_PANEL = "//div[@class ='rz-goods-main-content clearfix']";


    public RozetkaMainPage(WebDriver driver) {
        super(driver);
    }

    public RozetkaHeaderPanel getHeaderPanel() {
        return new RozetkaHeaderPanel(findBy(HEADER_PANEL), this);
    }
    public RozetkaContentPanel getContentPanel() {
        return new RozetkaContentPanel(findBy(CONTENT_PANEL), this);
    }


}
