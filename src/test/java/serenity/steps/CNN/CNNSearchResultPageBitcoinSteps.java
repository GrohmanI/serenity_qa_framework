package serenity.steps.CNN;

import core.pages.CNNPage;
import dto.CnnSearchItemDTO;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class CNNSearchResultPageBitcoinSteps extends ScenarioSteps {

    private CNNPage cnnPage;

    public CNNSearchResultPageBitcoinSteps (final Pages pages){
        this.cnnPage = pages.getPage(CNNPage.class);
    }

    @Step
    public void openCNNPage(final String url) {
        cnnPage.openAt(url);
    }
    @Step
    public void clickSearchButton(){
        cnnPage.getHeaderPanel().clickSearchButton();
    }

    @Step
    public void typeInputWord(String searchWord) {
        cnnPage.getHeaderPanel().typeTextToSearch(searchWord);

    }
    @Step
    public List<CnnSearchItemDTO> getDisplayedResults() {
        return cnnPage.getDisplayedResults();
    }




}
