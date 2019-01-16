package jbehave.scenariosteps.cnn;

import dto.CnnSearchResults;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import serenity.steps.CNN.CNNApiBitcoinSteps;

public class CnnSearchApiBitcoinScenario {

    @Steps
    private CNNApiBitcoinSteps cnnApiBitcoinSteps;


    @Given("request with GET Method")
    public void searchUsingAPI() {
        final CnnSearchResults apiSearchResults = cnnApiBitcoinSteps.getApiSearchBitcoinResults();
        Serenity.setSessionVariable("API_RESULTS").to(apiSearchResults);
    }
}
