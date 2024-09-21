package hieu.nv.jpa.course.repository;

import hieu.nv.jpa.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}