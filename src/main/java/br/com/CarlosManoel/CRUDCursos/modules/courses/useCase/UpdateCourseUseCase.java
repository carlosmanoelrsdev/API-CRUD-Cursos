package br.com.CarlosManoel.CRUDCursos.modules.courses.useCase;

import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.UpdateCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;


    public CoursesEntity execute(UUID id, UpdateCourseDTO updateCourseDTO) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));


        if (updateCourseDTO.getName() != null) {
            course.setName(updateCourseDTO.getName());
        }

        if (updateCourseDTO.getCategory() != null) {
            course.setCategory(updateCourseDTO.getCategory());
        }

        return courseRepository.save(course);
    }
}
