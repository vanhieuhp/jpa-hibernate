package hieu.nv.jpa.user.repository;

import hieu.nv.jpa.user.dto.UserFilter;
import hieu.nv.jpa.user.entity.User;
import hieu.nv.jpa.user.entity.UserJoinOptions;
import hieu.nv.jpa.user.entity.UserType;
import jakarta.persistence.criteria.*;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, UserRepositoryCustom {

    @Override
//    @EntityGraph(value = "user[roles]")
    Optional<User> findById(String id);

    @EntityGraph(value = UserJoinOptions.USER_GROUP)
    User findByUsername(String username);

    @Override
    @EntityGraph(value = UserJoinOptions.USER_ROLE_LANGUAGE_GROUP)
    List<User> findAll();

    List<User> findByUserTypeIn(List<UserType> userTypes);

    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findByUserIds(List<String> userIds);

    @EntityGraph(value = UserJoinOptions.USER_ROLE)
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findByUserIdsAndJoinRoles(List<String> userIds);

    @EntityGraph(value = UserJoinOptions.USER_LANGUAGE)
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findByUserIdsAndJoinLanguages(List<String> userIds);

    @EntityGraph(value = UserJoinOptions.USER_LANGUAGE_GROUP)
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findByUserIdsAndJoinLanguagesAndGroups(List<String> userIds);

    @EntityGraph(value = UserJoinOptions.USER_ROLE_LANGUAGE)
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findByUserIdsAndJoinLanguagesAndRoles(List<String> userIds);

    record UserSpecification(@NonNull UserFilter filter) implements Specification<User> {


        @NotNull
        @Override
        public Predicate toPredicate(@NonNull Root<User> root, @NotNull CriteriaQuery<?> query, @NonNull CriteriaBuilder builder) {
            List<Predicate> exps = new ArrayList<>();
            filter.getUsername().ifPresent(username -> exps.add(builder.like(builder.lower(root.get("username")), String.format("%%%s%%", username.toLowerCase()))));

            filter.getGroups().ifPresent(groups -> {
                Join<Object, Object> groupJoin = root.join("h_groups", JoinType.INNER);
                Predicate[] predicates = groups.stream().map(group -> builder.equal(groupJoin.get("name"), group.getTitle())).toArray(Predicate[]::new);
                exps.add(builder.or(predicates));
            });

            return builder.and(exps.toArray(new Predicate[0]));
        }
    }
}
