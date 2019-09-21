package adapters;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.*;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UsersAdapter extends MainAdapter {
    public static final String URL = "https://reqres.in/api/";

    public JobUser post(JobUser user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(URL + "users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), JobUser.class);
    }

    public SingleUser get(String page, int responseCode) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(URL + page)
                .then()
                .statusCode(responseCode)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), SingleUser.class);
    }

    public UpdateUser put(UpdateUser user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .put(URL + "users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UpdateUser.class);
    }


    public UpdateUser patch(UpdateUser user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .patch(URL + "users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UpdateUser.class);
    }


    public int delete(String page) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .delete(URL + page)
                .then()
                .extract().response();

        return response.statusCode();
    }



    public RegisterSuccessful post(RegisterSuccessful user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(URL + "register")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), RegisterSuccessful.class);
    }


    public RegisterUnSuccessful post(RegisterUnSuccessful user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(URL + "register")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), RegisterUnSuccessful.class);
    }

    public Login loginSuccessful(Login user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(URL + "login")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), Login.class);
    }

    public Login loginUnSuccessful(Login user) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(URL + "login")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), Login.class);
    }
}