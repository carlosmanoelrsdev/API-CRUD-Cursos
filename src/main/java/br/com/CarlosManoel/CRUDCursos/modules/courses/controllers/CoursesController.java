package br.com.CarlosManoel.CRUDCursos.modules.courses.controllers;


import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.CreateCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.ResponseDeleteCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.dto.UpdateCourseDTO;
import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.service.CourseService;
import br.com.CarlosManoel.CRUDCursos.modules.courses.useCase.CreateCourseUseCase;
import br.com.CarlosManoel.CRUDCursos.modules.courses.useCase.DeleteCourseUseCase;
import br.com.CarlosManoel.CRUDCursos.modules.courses.useCase.UpdateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;
    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;


    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDTO createCourseDTO){
        try {
            var result = this.createCourseUseCase.execute(createCourseDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable UUID id, @RequestBody UpdateCourseDTO updateCourseDTO) {
        try {
            var result = this.updateCourseUseCase.execute(id, updateCourseDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDeleteCourseDTO> delete(@PathVariable UUID id) {
        try {
            var resul = this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok(resul);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CoursesEntity> active(@PathVariable UUID id) {
        return ResponseEntity.ok(courseService.active(id));
    }

}
