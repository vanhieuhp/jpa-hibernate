package hieu.nv.jpa.course.controller;

import hieu.nv.jpa.course.dto.CourseDto;
import hieu.nv.jpa.course.entity.Course;
import hieu.nv.jpa.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
