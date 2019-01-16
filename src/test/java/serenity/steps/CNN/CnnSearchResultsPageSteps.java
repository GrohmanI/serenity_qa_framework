package serenity.steps.CNN;

import core.pages.CnnSearchResultPage;
import dto.CnnSearchFilterCriteriaDTO;
import dto.CnnSearchItemDTO;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class CnnSearchResultsPageSteps extends ScenarioSteps {

    private CnnSearchResultPage cnnSearchResultPage;

    public CnnSearchResultsPageSteps(final Pages pages) {
        this.cnnSearchResultPage = pages.getPage(CnnSearchResultPage.class);
    }

    @Step
    public void openSearchResultPage(final String link) {
        cnnSearchResultPage.openAt(link);
    }

    @Step
    public void applyFilters(final CnnSearchFilterCriteriaDTO filters) {
        cnnSearchResultPage.applyFilters(filters);
    }

    @Step
    public List<CnnSearchItemDTO> getDisplayedResults() {
        return cnnSearchResultPage.getDisplayedResults();
    }


}