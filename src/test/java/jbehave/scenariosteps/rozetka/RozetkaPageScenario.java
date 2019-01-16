package jbehave.scenariosteps.rozetka;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import serenity.steps.rozetka.RozetkaPageSteps;

public class RozetkaPageScenario {

    @Steps
    private RozetkaPageSteps rozetkaPageSteps;

    @Given("user is opened Rozetka main page, using following url: '$link'")
    public void openRozetkaPage(final String url) {
        rozetkaPageSteps.openRozetkaPage(url);
    }


    @When("user types '$searchWord' into the search input")
    public void typeSearchInputWord(final String searchWord) {
        rozetkaPageSteps.typeInputWord(searchWord);
    }


    @When("user add to WishList mail fake registration")
    public void addToWishList(){
        rozetkaPageSteps.clickFirstGoods();
        rozetkaPageSteps.clickButtonWishList();
        rozetkaPageSteps.typeFakeEmail();
        rozetkaPageSteps.clickButtonSave();
        rozetkaPageSteps.typeFakeFio();
        rozetkaPageSteps.clickButtonSave();
        rozetkaPageSteps.closePopup();
    }

    @When("user open 'WishList'")
    public void  openWishList(){
        rozetkaPageSteps.clickOpenWishList();
        rozetkaPageSteps.closePopup2();
    }

    @Then("next event 'Huawei Mate 20 Pro' should be displayed")
    public void verifyGoodsInWishList() {
        final String unit = rozetkaPageSteps.getWishListItems().get(0);
        final String actualResult = unit.substring(24, 42);

        final String expectedGood = "Huawei Mate 20 Pro";
        Assert.assertEquals("There is incorrect Goods present !",
                expectedGood, actualResult);
    }

}
