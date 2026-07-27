package br.com.CarlosManoel.CRUDCursos.modules.courses.service;


import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CoursesEntity> ListCourse() {
        return courseRepository.findAll();
    }

    public List<CoursesEntity> ListCourseNameCategory(String name, String category) {

        if (name != null && category != null) {
            return courseRepository.findByNameOrCategoryContainingIgnoreCase(name, category);
        }

        if (name != null) {
            return courseRepository.findByNameContainingIgnoreCase(name);
        }
        if (category != null) {
            return courseRepository.findByCategoryContainingIgnoreCase(category);
        }

        return courseRepository.findAll();

    }


    /**
     * @deprecated Use updateCourse(UpdateCourseDTO dto) em vez deste método.
     */
    @Deprecated
    public CoursesEntity update(UUID id, CoursesEntity coursesEntity) {

        CoursesEntity existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));


        existingCourse.setName(coursesEntity.getName());
        existingCourse.setCategory(coursesEntity.getCategory());

        return courseRepository.save(existingCourse);
    }

    /**
     * @deprecated Use DeleteCourseUseCase() em vez deste método.
     */
    @Deprecated
    public void delete(UUID id) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        courseRepository.delete(course);
    }


    @Deprecated
    public CoursesEntity active(UUID id) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        course.setActive(!course.getActive());

        return courseRepository.save(course);
    }


}
