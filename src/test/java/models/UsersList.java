package models;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class UsersList {
    @Expose
    int page;
    @Expose
    int perPage;
    @Expose
    int total;
    @Expose
    int totalPages;
    @Expose
    List<User> data;
}
