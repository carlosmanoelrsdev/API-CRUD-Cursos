package br.com.CarlosManoel.CRUDCursos.modules.courses.controllers;


import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.service.CourseService;
import br.com.CarlosManoel.CRUDCursos.modules.courses.usecase.CreateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;
    @Autowired
    private CourseService courseService;


    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CoursesEntity coursesEntity){
        try {
            var result = this.createCourseUseCase.execute(coursesEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursesEntity> update(@PathVariable UUID id, @RequestBody CoursesEntity coursesEntity) {

        CoursesEntity updateCourse = courseService.update(id, coursesEntity);

        return ResponseEntity.ok(updateCourse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        courseService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CoursesEntity> active(@PathVariable UUID id) {
        return ResponseEntity.ok(courseService.active(id));
    }

}
