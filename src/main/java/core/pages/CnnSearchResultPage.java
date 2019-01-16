package core.pages;

import dto.CnnSearchFilterCriteriaDTO;
import dto.CnnSearchItemDTO;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CnnSearchResultPage extends AbstractPage {
    private static final String ARTICLE_TITLE = "//label[text()='%s']";
    private static final String CATEGORY_FILTERS = "//label[@for='left_travel' and text()='%s']";
    private static final String ALL_DISPLAYED_RESULTS = "//div[@class='cnn-search__results-list']/div";

    public CnnSearchResultPage(final WebDriver driver) {
        super(driver);
    }
    public void applyFilters(final CnnSearchFilterCriteriaDTO filter){
        final String articleLocator = String.format(ARTICLE_TITLE, filter.getType());
        final String categoryLocator = String.format(CATEGORY_FILTERS, filter.getCategory());
        findBy(articleLocator).then().click();
        findBy(categoryLocator).then().click();

    }
    public List<CnnSearchItemDTO> getDisplayedResults(){
        final List <CnnSearchItemDTO> displayedItems = new ArrayList<>();

        final List<WebElementFacade> allResults = findAll(ALL_DISPLAYED_RESULTS);

        for(final WebElementFacade item : allResults){
            final CnnSearchItemDTO cnnSearchItemDTO = new CnnSearchItemDTO();

            final String headLine = item.then(".//h3").waitUntilVisible().getText();
            System.out.println("headline" + headLine);
            final String body = item.then(".//div[@class='cnn-search__result-body']").waitUntilVisible().getText();
            System.out.println("body" + body);
            cnnSearchItemDTO.setHeadline(headLine);
            cnnSearchItemDTO.setBody(body);
            displayedItems.add(cnnSearchItemDTO);



        }
        return  displayedItems;
    }
}
