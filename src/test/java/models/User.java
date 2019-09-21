package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @Expose
    int id;
    @Expose
    String email;
    @Expose
    @SerializedName("first_name")
    String firstName;
    @Expose
    @SerializedName("last_name")
    String lastName;
    @Expose
    String avatar;
}
