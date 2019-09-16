package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UsersList;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UserListAdapter {

    public UsersList get() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UsersList.class);
    }
}
