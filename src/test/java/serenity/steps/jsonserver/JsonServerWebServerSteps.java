package serenity.steps.jsonserver;

import core.ws.AbstractWsConfiguration;
import dto.PostDTO;
import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Step;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;

public class JsonServerWebServerSteps extends AbstractWsConfiguration {
    private static final String JSON_LOCALHOST_SERVER_URL = "http://localhost:3000";
    private static final String POSTS_API_PATH ="/posts";
    private static final String COMMENTS_API_PATH = "/comments";
    private static final String PROFILE_API_PATH = "/profile";

    @Step
    public void createNewPost(final PostDTO postDTO){
        final String postDTOJson = JsonUtils.toJson(postDTO);
        given().baseUri(JSON_LOCALHOST_SERVER_URL).contentType(ContentType.JSON).body(postDTOJson).post(POSTS_API_PATH);
    }
    @Step
    public PostDTO getCreatedResource(final String id){
        final String createdPostApiPath = String.format("%s/%s",POSTS_API_PATH,id);
        return given().baseUri(JSON_LOCALHOST_SERVER_URL).contentType(ContentType.JSON).get(createdPostApiPath).as(PostDTO.class);
    }

    @Step
    public void deleteResourceById(final String id) {
        final String createdPostApiPath = String.format("%s/%s",POSTS_API_PATH, id);
        given().baseUri(JSON_LOCALHOST_SERVER_URL)
                .contentType(ContentType.JSON)
                .delete(createdPostApiPath);
    }
    @Step
    public void modifyResourceById(final String id, final PostDTO updateJsonDTO) {
        final String updateJsonBody = JsonUtils.toJson(updateJsonDTO);
        final String modifyPostApiPath = String.format("%s/%s",POSTS_API_PATH, id);
        given().baseUri(JSON_LOCALHOST_SERVER_URL)
                .contentType(ContentType.JSON)
                .body(updateJsonBody)
                .put(modifyPostApiPath);
    }
}
