package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UsersList;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UserListAdapter extends MainAdapter{

    public UsersList get(String page, int responseCode) {

        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
        .when()
                .get(String.format("https://reqres.in/api/" + page))
        .then()
                .statusCode(responseCode)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), UsersList.class);
    }
}
