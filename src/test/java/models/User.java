package models;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class User {
    @Expose
    int id;
    @Expose
    String email;
    @Expose
    String firstName;
    @Expose
    String lastName;
    @Expose
    String avatar;
}
