package br.com.CarlosManoel.CRUDCursos.modules.courses.useCase;

import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.ResponseDeleteCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseDeleteCourseDTO execute(UUID id) {
        CoursesEntity courses = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        ResponseDeleteCourseDTO response = new ResponseDeleteCourseDTO();

        response.setId(courses.getId());
        response.setName(courses.getName());
        response.setCategory(courses.getCategory());

        courseRepository.delete(courses);

        return response;
    }
}
