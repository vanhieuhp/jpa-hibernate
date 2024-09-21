package hieu.nv.jpa.course.repository;

import hieu.nv.jpa.course.entity.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails, String> {
}