package hieu.nv.jpa.workers.repository;

import hieu.nv.jpa.workers.entity.WorkerTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerTaskRepository extends JpaRepository<WorkerTask, String> {
}