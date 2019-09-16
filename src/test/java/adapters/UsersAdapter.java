package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.JobUser;
import models.UsersList;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class UsersAdapter {

    public JobUser post(JobUser user) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        
        Response response = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(user))
        .when()
            .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .contentType(ContentType.JSON).extract().response();

        return gson.fromJson(response.asString().trim(), JobUser.class);
    }
}
