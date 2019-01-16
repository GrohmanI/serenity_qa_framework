package serenity.steps.CNN;

import core.ws.AbstractWsConfiguration;
import dto.CnnSearchResults;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;

public class CnnApiSteps extends AbstractWsConfiguration {

    private static final String CNN_API_URL = "https://search.api.cnn.io";
    private static final String CNN_API_SEARCH_PARAMETERS = "/content?q=bitcoin&size=10&category=travel";

    @Step
    public CnnSearchResults getApiSearchResults() {
        return RestAssured.given()
                .baseUri(CNN_API_URL)
                .get(CNN_API_SEARCH_PARAMETERS)
                .as(CnnSearchResults.class);
    }
}