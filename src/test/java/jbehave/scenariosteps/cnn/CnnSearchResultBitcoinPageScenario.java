package jbehave.scenariosteps.cnn;


import dto.CnnSearchItemDTO;
import dto.CnnSearchResults;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;
import serenity.steps.CNN.CNNSearchResultPageBitcoinSteps;

import java.util.List;

public class CnnSearchResultBitcoinPageScenario {

    @Steps
    private CNNSearchResultPageBitcoinSteps cnnSearchResultPageBitcoinSteps;

    @When("user opened CNN page, using following link: '$link'")
    public void openCNNPage(final String link) {

        cnnSearchResultPageBitcoinSteps.openCNNPage(link);
    }


    @When("type input Search '$searchWord'")
    public void typeSearchInputWord(final String searchWord) {
        cnnSearchResultPageBitcoinSteps.clickSearchButton();
        cnnSearchResultPageBitcoinSteps.typeInputWord(searchWord);
    }



    @Then("API search results should be same as on the Search Bitcoin result page")
    public void areTheApiSearchResultsSameAsOnThePage() {
        final CnnSearchResults cnnSearchResults = Serenity.sessionVariableCalled("API_RESULTS");
        final List<CnnSearchItemDTO> displayedItems = cnnSearchResultPageBitcoinSteps.getDisplayedResults();
        ReflectionAssert.assertReflectionEquals("There are incorrect items displayed!",
                cnnSearchResults.getResult(), displayedItems);
    }


}
