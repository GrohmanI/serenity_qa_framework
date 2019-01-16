package jbehave.scenariosteps.sportcheck;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import serenity.steps.sportcheck.SportcheckMainPageSteps;

import java.util.List;

public class SportcheckMainPageScenario {

    @Steps
    private SportcheckMainPageSteps sportcheckMainPageSteps;

    @Given("user is opened Sportcheck main page, using following url : '$link'")
    public void openSportCheckPage(final String link) {
        sportcheckMainPageSteps.openPage(link);
    }

    @When("user clicks 'Shop Categories' button")
    public void clickShopCategoriesButton() {
        sportcheckMainPageSteps.expandShopCategoriesList();
    }

    @Then("next categories should be displayed: '$categoryList'")
    public void verifyShopCategoryList(final List<String> expectedShopCategories){
       final List<String> actualShopCategoriesList = sportcheckMainPageSteps.getShopCategoriesList();
        Assert.assertArrayEquals("There are incorrect 'Shop categories' displayed" ,
                expectedShopCategories.toArray(), actualShopCategoriesList.toArray());
    }
}


