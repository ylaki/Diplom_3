package client;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.UserData;

import static io.restassured.RestAssured.given;
public class User {
    private static final String REGISTER_ENDPOINT = "api/auth/register";
    private static final String LOGIN_ENDPOINT = "api/auth/login";
    private static final String USER_ENDPOINT = "api/auth/user";

    @Step("Create user")
    public Response create(UserData user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(REGISTER_ENDPOINT);
    }

    @Step("Sign in with user login")
    public Response login(UserData credentials) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(credentials)
                .when()
                .post(LOGIN_ENDPOINT);
    }

    @Step("Delete user")
    public Response delete(String bearerToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization",bearerToken)
                .when()
                .delete(USER_ENDPOINT);
    }
}