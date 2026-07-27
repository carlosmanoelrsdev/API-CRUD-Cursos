package br.com.CarlosManoel.CRUDCursos.modules.courses.useCase;

import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.ResponseActiveCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CoursesEntity execute(UUID id) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not Found"));

        ResponseActiveCourseDTO response = new ResponseActiveCourseDTO();

        response.setId(course.getId());
        response.setActive(course.getActive());
        response.setName(course.getName());
        response.setCategory(course.getCategory());

        course.setActive(!course.getActive());

        return courseRepository.save(course);

    }
}
