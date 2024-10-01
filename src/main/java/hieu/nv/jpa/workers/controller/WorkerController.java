package hieu.nv.jpa.workers.controller;

import hieu.nv.jpa.workers.entity.Worker;
import hieu.nv.jpa.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

	private final WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> getAllWorkers() {
		return ResponseEntity.ok(workerService.getAllWorkers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> getWorkerById(@PathVariable String id) {
		return ResponseEntity.ok(workerService.getWorkerById(id));
	}

	@PostMapping
	public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
		return ResponseEntity.ok(workerService.createWorker(worker));
	}
}
