package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterSuccessful {
    @Expose
    String email;
    @Expose
    String password;
    @Expose
    String  id;
    @Expose
    String token;
}
