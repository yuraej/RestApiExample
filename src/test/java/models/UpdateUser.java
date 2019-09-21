package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUser {
    @Expose
    private String name;
    @Expose
    private String job;
    @Expose
    private String updatedAt;
}
