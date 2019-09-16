package models;

import com.google.gson.annotations.Expose;
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
    String firstName;
    @Expose
    String lastName;
    @Expose
    String avatar;
}
