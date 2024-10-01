package hieu.nv.jpa.workers.service;

import hieu.nv.jpa.workers.entity.Worker;
import hieu.nv.jpa.workers.entity.WorkerTask;
import hieu.nv.jpa.workers.repository.WorkerRepository;
import hieu.nv.jpa.workers.repository.WorkerTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

	private final WorkerRepository workerRepository;
	private final WorkerTaskRepository workerTaskRepository;

	@Override
	public List<Worker> getAllWorkers() {
		return workerRepository.findAll();
	}

	@Override
	public Worker getWorkerById(String id) {
		return workerRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Worker createWorker(Worker worker) {
		Worker savedWorker = workerRepository.save(worker);
		WorkerTask workerTask1 = new WorkerTask();
		workerTask1.setAssignedWorker(savedWorker);
		workerTask1.setTaskName("Task 1");
		workerTaskRepository.save(workerTask1);

		WorkerTask workerTask2 = new WorkerTask();
		workerTask2.setAssignedWorker(savedWorker);
		workerTask2.setTaskName("Task 2");
		workerTaskRepository.save(workerTask2);

		WorkerTask workerTask3 = new WorkerTask();
		workerTask3.setAssignedWorker(savedWorker);
		workerTask3.setTaskName("Task 3");
		workerTaskRepository.save(workerTask3);

		return savedWorker;
	}
}
