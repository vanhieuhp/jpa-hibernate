package hieu.nv.jpa.user.dto;

import hieu.nv.jpa.user.entity.User;
import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private User.UserType userType;
    private User.UserShortType userShortType;
}
