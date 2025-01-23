package hieu.nv.jpa.user.repository;

import hieu.nv.jpa.user.entity.User;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRepositoryImpl implements UserRepositoryCustom {

	private final EntityManager entityManager;

	public List<User> findByUserIdsWithDynamicEntityGraph(List<String> userIds, String entityGraphName) {
		// Create a JPA Query
		TypedQuery<User> query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.id IN :userIds", User.class);
		query.setParameter("userIds", userIds);

		// Apply the EntityGraph dynamically
		EntityGraph<?> entityGraph = entityManager.getEntityGraph(entityGraphName);
		query.setHint("javax.persistence.fetchgraph", entityGraph);

		// Execute the query
		return query.getResultList();
	}
}
