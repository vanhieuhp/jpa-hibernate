package hieu.nv.jpa.user.repository;

import hieu.nv.jpa.user.dto.UserFilter;
import hieu.nv.jpa.user.entity.User;
import jakarta.persistence.criteria.*;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

	@Override
	@EntityGraph(value = "user[roles]")
	Optional<User> findById(String id);

	@EntityGraph(value = "user[h_groups]")
	User findByUsername(String username);

	@Override
	@EntityGraph(value = "user[roles][h_groups]")
	List<User> findAll();

	record UserSpecification(@NonNull UserFilter filter) implements Specification<User> {


		@Override
		public Predicate toPredicate(@NonNull Root<User> root,
		                             @NonNull CriteriaQuery<?> query,
		                             @NonNull CriteriaBuilder builder) {
			List<Predicate> exps = new ArrayList<>();
			filter.getUsername().ifPresent(username ->
				exps.add(
					builder.like(
						builder.lower(root.get("username")), String.format("%%%s%%", username.toLowerCase()))
				)
			);

			filter.getGroups().ifPresent(groups -> {
				Join<Object, Object> groupJoin = root.join("h_groups", JoinType.INNER);
				Predicate[] predicates = groups.stream()
						.map(group -> builder.equal(groupJoin.get("name"), group.getTitle()))
						.toArray(Predicate[]::new);
				exps.add(builder.or(predicates));
			});

			return builder.and(exps.toArray(new Predicate[0]));
		}
	}
}
