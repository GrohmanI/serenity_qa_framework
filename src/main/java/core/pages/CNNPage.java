package core.pages;

import core.panels.CNNContentSearchPanel;
import core.panels.CNNHeaderPanel;
import dto.CnnSearchItemDTO;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CNNPage extends AbstractPage {
    private static final String HEADER_PANEL = "//div[@id='nav']";
    private static final String CONTENT_SEARCH_PANEL = "//div[@class='cnn-search__right']";
    private static final String ALL_DISPLAYED_RESULTS = "//div[@class='cnn-search__results-list']/div";

    public CNNPage(WebDriver driver) {
        super(driver);
    }

    public CNNHeaderPanel getHeaderPanel() {
        return new CNNHeaderPanel(findBy(HEADER_PANEL), this);
    }
    public CNNContentSearchPanel getContentPanel() {
        return new CNNContentSearchPanel(findBy(CONTENT_SEARCH_PANEL), this);
    }

    public List<CnnSearchItemDTO> getDisplayedResults(){
        final List <CnnSearchItemDTO> displayedItems = new ArrayList<>();

        final List<WebElementFacade> allResults = findAll(ALL_DISPLAYED_RESULTS);

        for(final WebElementFacade item : allResults){
            final CnnSearchItemDTO cnnSearchItemDTO = new CnnSearchItemDTO();
            final String body = item.then(".//div[@class='cnn-search__result-body']").getText().replaceAll("\\s+", " ");
            System.out.println("body" + body);
            final String headLine = item.then(".//h3").getText();
            System.out.println("headline" + headLine);

            cnnSearchItemDTO.setHeadline(headLine);
            cnnSearchItemDTO.setBody(body);
            displayedItems.add(cnnSearchItemDTO);
        }
        return  displayedItems;
    }
}
