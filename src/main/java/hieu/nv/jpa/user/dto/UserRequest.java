package hieu.nv.jpa.user.dto;

import hieu.nv.jpa.user.entity.UserShortType;
import hieu.nv.jpa.user.entity.UserType;
import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private UserType userType;
    private UserShortType userShortType;
}
