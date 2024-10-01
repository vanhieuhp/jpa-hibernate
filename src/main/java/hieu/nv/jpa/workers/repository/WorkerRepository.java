package hieu.nv.jpa.workers.repository;

import hieu.nv.jpa.workers.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, String> {
}