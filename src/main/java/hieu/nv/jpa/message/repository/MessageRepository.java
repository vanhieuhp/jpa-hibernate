package hieu.nv.jpa.message.repository;

import hieu.nv.jpa.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}