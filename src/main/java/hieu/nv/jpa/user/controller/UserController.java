package hieu.nv.jpa.user.controller;

import hieu.nv.jpa.user.dto.FilterDto;
import hieu.nv.jpa.user.dto.UserFilterDto;
import hieu.nv.jpa.user.dto.UserRequest;
import hieu.nv.jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody UserRequest user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserRequest user) {
		return ResponseEntity.ok(userService.createUser(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/username")
	public ResponseEntity<?> findByUsername(@RequestParam("username") String username) {
		return ResponseEntity.ok(userService.findByUsername(username));
	}

	@PostMapping("/filter")
	public ResponseEntity<?> filter(@RequestBody UserFilterDto filter) {
		return ResponseEntity.ok(userService.filterUser(filter));
	}

	@PostMapping("/ids")
	public ResponseEntity<?> filter(@RequestBody List<String> userIds) {
		return ResponseEntity.ok(userService.findByUserIds(userIds));
	}
}
