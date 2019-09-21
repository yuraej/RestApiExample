package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUnSuccessful {
    @Expose
    private String email;
    @Expose
    private  String error;
}
