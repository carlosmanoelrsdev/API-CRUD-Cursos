package br.com.CarlosManoel.CRUDCursos.modules.courses.usecase;

import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;


@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CoursesEntity execute(CoursesEntity coursesEntity){
        this.courseRepository.findByName(coursesEntity.getName()).ifPresent((user) -> {
            try {
                throw new NameNotFoundException("teste");
            } catch (NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }) ;

        return this.courseRepository.save(coursesEntity);
    }

}