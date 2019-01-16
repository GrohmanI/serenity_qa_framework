package serenity.steps.starwars;

import core.ws.AbstractWsConfiguration;
import dto.AllStarWarsUsers;
import dto.Films;
import dto.StarWarsUser;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;

public class StarWarsGetLuckFilms extends AbstractWsConfiguration {

    private static final String SERVER_BASE_URL = "https://swapi.co/api";
    private static final String ALL_USERS_PATH = "/people/";

    @Step
    public AllStarWarsUsers getAllUsers() {
        RestAssured.baseURI = SERVER_BASE_URL;
        return RestAssured.get(ALL_USERS_PATH).as(AllStarWarsUsers.class);

    }

    @Step
    public String getTitleFilms(String t) {

        return RestAssured.get(t).as(Films.class).getTitle();
    }

//Меняем ссылки на фильмы у Люка Скайвокера

    public static void main(String[] args) {
        final serenity.steps.starwars.StarWarsGetLuckFilms steps = new serenity.steps.starwars.StarWarsGetLuckFilms();
        final AllStarWarsUsers allUsers = steps.getAllUsers();
        StarWarsUser[] array = allUsers.getResults();

        String[] films;
        String luk = "Luke Skywalker";

        for (StarWarsUser e : array) {

            if (e.getName().equals(luk)) {

                films = e.getFilms();

                for (int i = 0; i < films.length; i++) {

                    String k = films[i];
                    String films1 = steps.getTitleFilms(k);
                    films[i] = films1;
                }
            }
        }


    }
}
