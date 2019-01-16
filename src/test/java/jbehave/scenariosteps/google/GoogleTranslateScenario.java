package jbehave.scenariosteps.google;

import dto.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import serenity.steps.google.GoogleTranslateSteps;

public class GoogleTranslateScenario {

    @Steps
    private GoogleTranslateSteps googleTranslateSteps;

    @Given("user is opened '$translateSiteUrl' site")
    public void openGoogleTranslateSite(final String siteUrl) {
        googleTranslateSteps.openGoogleTranslateSite(siteUrl);
    }

    @When("user choose following language '$sourceLanguage' as a source")
    public void typeSourceLanguage(final String language) {
        googleTranslateSteps.selectSourceLanguage(language);
    }

    @When("user choose following language '$sourceLanguage' as a target")
    public void typeTargetLanguage(final String language) {
        googleTranslateSteps.selectTargetLanguage(language);
    }

    @When("user types '$requiredInputToTranslate' into the source input")
    public void typeTranslationInputWord(final String translationWord) {
        googleTranslateSteps.typeTranslationInputWord(translationWord);
    }

    @When("user fills in following registration info: $parameters")
    public void doSmth(final ExamplesTable $parameters){
        final User user = $parameters.getRowsAs(User.class).get(0);
    }

    @Then("user should see next translated world '$expectedTranslatedWord'")
    public void isWordTranslatedCorrectly(final String expectedTranslatedWord) {
        final String actualTranslatedWord = googleTranslateSteps.getTranslatedWord();
        Assert.assertEquals("There is incorrect translation displayed!",
                expectedTranslatedWord, actualTranslatedWord);
    }
}
