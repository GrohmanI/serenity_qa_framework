package jbehave.scenariosteps.cnn;

import dto.CnnSearchResults;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import serenity.steps.CNN.CnnApiSteps;

public class CnnSearchApiScenario {

    @Steps
    private CnnApiSteps cnnApiSteps;

    @Given("user retrieved the cnn search results, using API")
    public void searchUsingAPI() {
        final CnnSearchResults apiSearchResults = cnnApiSteps.getApiSearchResults();
        Serenity.setSessionVariable("API_RESULTS").to(apiSearchResults);
    }
}