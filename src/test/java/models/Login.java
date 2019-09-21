package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Login {
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private String token;
    @Expose
    private  String error;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login(String email) {
        this.email = email;
    }
}
