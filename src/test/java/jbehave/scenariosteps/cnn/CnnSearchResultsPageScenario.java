package jbehave.scenariosteps.cnn;

import dto.CnnSearchFilterCriteriaDTO;
import dto.CnnSearchItemDTO;
import dto.CnnSearchResults;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;
import serenity.steps.CNN.CnnSearchResultsPageSteps;

import java.util.List;

public class CnnSearchResultsPageScenario {

    @Steps
    private CnnSearchResultsPageSteps cnnSearchResultsPageSteps;

    @When("user opens the cnn page, by following link: '$link'")
    public void openCnnSearchPage(final String link) {
        cnnSearchResultsPageSteps.openSearchResultPage(link);
    }

    @When("user filtering displayed results, using next filter criteria: $criteria")
    public void applyRequiredFilters(final ExamplesTable criteria) {
        final CnnSearchFilterCriteriaDTO filter = criteria.getRowsAs(CnnSearchFilterCriteriaDTO.class).get(0);
        cnnSearchResultsPageSteps.applyFilters(filter);
    }

    @Then("API search results should be same as on the Search result page")
    public void areTheApiSearchResultsSameAsOnThePage() {
        final CnnSearchResults cnnSearchResults = Serenity.sessionVariableCalled("API_RESULTS");
        final List<CnnSearchItemDTO> displayedItems = cnnSearchResultsPageSteps.getDisplayedResults();
        ReflectionAssert.assertReflectionEquals("There are incorrect items displayed!",
                cnnSearchResults.getResult(), displayedItems);
    }
}