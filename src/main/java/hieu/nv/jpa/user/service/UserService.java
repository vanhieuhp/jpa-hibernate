package hieu.nv.jpa.user.service;

import hieu.nv.jpa.user.dto.UserFilterDto;
import hieu.nv.jpa.user.dto.UserRequest;
import hieu.nv.jpa.user.entity.User;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public interface UserService {

    User createUser(UserRequest user);

    User getUserById(String id);

    User updateUser(String id, UserRequest user);

    void deleteUser(String id);

    List<User> getAllUsers();

    User findByUsername(String username);

    List<User> filterUser(@NotNull UserFilterDto filter);


}
