package hieu.nv.jpa.user.service;

import hieu.nv.jpa.group.entity.Group;
import hieu.nv.jpa.user.dto.FilterDto;
import hieu.nv.jpa.user.dto.UserFilter;
import hieu.nv.jpa.user.dto.UserFilterDto;
import hieu.nv.jpa.user.dto.UserRequest;
import hieu.nv.jpa.user.entity.User;
import hieu.nv.jpa.user.entity.UserType;
import hieu.nv.jpa.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

@Service("userService")
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public User createUser(UserRequest user) {
        User newUser = new User();
        userRepository.save(newUser);

        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUserType(user.getUserType());
        newUser.setShortType(user.getUserShortType());
        return newUser;
    }

    @Override
//    @Transactional
    public User getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        log.info("Full name: {}", user.getFullName());
        User result = new User();
        result.setUsername(user.getUsername());
        result.setRoles(user.getRoles());
        return result;
//        return user;
    }

    @Override
    @Transactional
    public User updateUser(String id, UserRequest user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return existingUser;
//        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> filterUser(@NotNull UserFilterDto filter) {

        Pageable pagination = PageRequest.of(
                filter.getPageNumber(), filter.getPageSize(), getSort(filter));

        UserRepository.UserSpecification specification = new UserRepository.UserSpecification(
                this.toUserFilter(filter)
        );

        Page<User> page =  userRepository.findAll(where(specification), pagination);

        return page.getContent();
    }

    @Override
    public List<User> listUserType() {
        List<User> users = userRepository.findByUserTypeIn(List.of(UserType.USER, UserType.ADMIN));
        return users.stream()
                .map(user -> {
                    User result = new User();
                    result.setId(user.getId());
                    result.setUsername(user.getUsername());
                    result.setRoles(user.getRoles());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findByUserIds(List<String> userIds) {
        return userRepository.findByUserIds(userIds).stream()
                .map(user -> {
                    User result = new User();
                    result.setId(user.getId());
                    result.setUsername(user.getUsername());
//                    result.setRoles(user.getRoles());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @NonNull
    public Sort getSort(@NotNull FilterDto filterDto) {
        Sort sort = Sort.by("id").descending();
        if (Objects.nonNull(filterDto.getSort())
                && Objects.nonNull(filterDto.getSort().getActive())
                && Objects.nonNull(filterDto.getSort().getDirection())) {
            if (filterDto.getSort().getDirection().equals("ASC")
                    || filterDto.getSort().getDirection().equals("asc")) {
                sort = Sort.by(filterDto.getSort().getActive()).ascending();
            } else if (filterDto.getSort().getDirection().equals("DESC")
                    || filterDto.getSort().getDirection().equals("desc")) {
                sort = Sort.by(filterDto.getSort().getActive()).descending();
            }
        }
        return sort;
    }

    public UserFilter toUserFilter(UserFilterDto filter) {
        if (filter.getGroups() == null) {
            filter.setGroups(new HashSet<>());
        }

        Set<Group> h_groups = filter.getGroups().stream()
                .map(group -> Group.builder().title(group).build())
                .collect(Collectors.toSet());
        return UserFilter.builder()
                .username(filter.getUsername())
                .h_groups(h_groups)
                .build();
    }
}
