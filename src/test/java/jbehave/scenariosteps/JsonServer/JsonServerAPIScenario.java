package jbehave.scenariosteps.JsonServer;

import dto.PostDTO;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.unitils.reflectionassert.ReflectionAssert;
import serenity.steps.jsonserver.JsonServerWebServerSteps;

public class JsonServerAPIScenario {
    @Steps
    private JsonServerWebServerSteps webServicesSteps;
    private static final String REQUIRED_RESOURCE_ID = "id_key";


    @Given("user is deleted following resource with id '$resourceId'")
    public void deleteResourceById(final String id) {
        Serenity.setSessionVariable(REQUIRED_RESOURCE_ID).to(id);
        webServicesSteps.deleteResourceById(id);
    }


    @Given("user modified created post with id '$resourceId', using following details: $details")
    public void modifyCreatedResourceById(final String id, final ExamplesTable details) {
        final PostDTO updateJsonDTO = details.getRowsAs(PostDTO.class).get(0);
        webServicesSteps.modifyResourceById(id, updateJsonDTO);
    }

    @Then("resource should be not available")
    public void isResourceNotAvailable() {
        final String id = Serenity.sessionVariableCalled(REQUIRED_RESOURCE_ID);
        final PostDTO createdResource = webServicesSteps.getCreatedResource(id);
        Assert.assertNull("Author is not null!", createdResource.getAuthor());
        Assert.assertNull("Title is not null!", createdResource.getTitle());
    }

    @Given("user creates new post with following details: $details")
    public void createNewPostWithDetails(final ExamplesTable details) {
        final PostDTO postDTO = details.getRowsAs(PostDTO.class).get(0);
        webServicesSteps.createNewPost(postDTO);
    }

    @Then("created post with id '$resourceId' should be available with next details: $details")
    @Alias("modified post with id '$resourceId' should be available with next details: $details")
    public void isCreatedPostAvailable(final String id, final ExamplesTable details) {
        final PostDTO expectedPostDetail = details.getRowsAs(PostDTO.class).get(0);
        final PostDTO actualPostDetails = webServicesSteps.getCreatedResource(id);
        ReflectionAssert.assertReflectionEquals("There is no available post",
                expectedPostDetail, actualPostDetails);
    }
}
