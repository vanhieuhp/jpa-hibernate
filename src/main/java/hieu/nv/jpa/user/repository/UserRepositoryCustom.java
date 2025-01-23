package hieu.nv.jpa.user.repository;

import hieu.nv.jpa.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

	List<User> findByUserIdsWithDynamicEntityGraph(List<String> userIds, String entityGraphName);
}
