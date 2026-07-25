package br.com.CarlosManoel.CRUDCursos.modules.courses.useCase;

import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.CreateCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CoursesEntity execute(CreateCourseDTO createCourseDTO){
        CoursesEntity course = new CoursesEntity();

        course.setName(createCourseDTO.getName());
        course.setCategory(createCourseDTO.getCategory());
        course.setTeacher(createCourseDTO.getTeacher());

        return this.courseRepository.save(course);
    }

}