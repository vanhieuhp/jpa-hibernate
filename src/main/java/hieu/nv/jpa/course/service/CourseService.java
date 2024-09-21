package hieu.nv.jpa.course.service;

import hieu.nv.jpa.course.dto.CourseDto;
import hieu.nv.jpa.course.entity.Course;

public interface CourseService {
    Course createCourse(CourseDto course);

    Course getCourseById(String id);

    Iterable<Course> getAllCourses();
}
