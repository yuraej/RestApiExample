package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UsersList;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UserListAdapter {

    public UsersList get(int page) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
        .when()
                .get(String.format("https://reqres.in/api/users?page=%s", page))
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UsersList.class);
    }
}
