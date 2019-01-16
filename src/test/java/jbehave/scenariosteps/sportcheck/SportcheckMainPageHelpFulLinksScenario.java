package jbehave.scenariosteps.sportcheck;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import serenity.steps.sportcheck.SportcheckMainPageHelpFulLinksSteps;

import java.awt.*;
import java.util.List;

public class SportcheckMainPageHelpFulLinksScenario {

    @Steps
    private SportcheckMainPageHelpFulLinksSteps sportcheckMainPageHelpFulLinksSteps;

    @Given("user is opened Sportcheck main page, using following url: '$link'")
    public void openSportCheckPage(final String link) {
        sportcheckMainPageHelpFulLinksSteps.openPage(link);
    }

    @When("user 'scrolled' down page")
    public void scrollsSportCheckPage() throws InterruptedException {
        sportcheckMainPageHelpFulLinksSteps.scrollsToEnd();
    }

    @Then("next helpful links should be displayed: '$helpFullList'")
    public void verifyHelpFulLinks(final List<String> expectedHelpFulLinks){
        final List<String> actualHelpFulLinks = sportcheckMainPageHelpFulLinksSteps.getHelpfulLinksList();
        Assert.assertArrayEquals("There are incorrect 'HelpFulLinks' displayed" ,
                expectedHelpFulLinks.toArray(), actualHelpFulLinks.toArray());
    }
}
