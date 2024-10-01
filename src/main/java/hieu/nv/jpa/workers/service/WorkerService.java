package hieu.nv.jpa.workers.service;

import hieu.nv.jpa.workers.entity.Worker;

import java.util.List;

public interface WorkerService {
	List<Worker> getAllWorkers();

	Worker getWorkerById(String id);

	Worker createWorker(Worker worker);
}
