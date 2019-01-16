package core.ws;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.thucydides.core.steps.ScenarioSteps;

public abstract class AbstractWsConfiguration extends ScenarioSteps {
    public AbstractWsConfiguration() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
