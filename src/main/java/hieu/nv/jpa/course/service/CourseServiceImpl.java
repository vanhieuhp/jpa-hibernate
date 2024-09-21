package hieu.nv.jpa.course.service;

import hieu.nv.jpa.course.dto.CourseDto;
import hieu.nv.jpa.course.entity.Course;
import hieu.nv.jpa.course.entity.CourseDetails;
import hieu.nv.jpa.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    @Override
    public Course createCourse(CourseDto course) {
        Course newCourse = new Course();
        newCourse.setTitle(course.getTitle());
        courseRepository.save(newCourse);

        CourseDetails details = new CourseDetails();
        details.setDescription(course.getCourseDetails().getDescription());
        details.setCourse(newCourse);

        newCourse.setCourseDetails(details);

        return newCourse;
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
