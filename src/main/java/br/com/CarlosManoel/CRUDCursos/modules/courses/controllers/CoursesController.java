package br.com.CarlosManoel.CRUDCursos.modules.courses.controllers;


import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.usecase.CreateCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CoursesEntity coursesEntity){
        try {
            var result = this.createCourseUseCase.execute(coursesEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
