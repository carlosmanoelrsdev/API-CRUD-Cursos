package br.com.CarlosManoel.CRUDCursos.modules.courses.controllers;

import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import br.com.CarlosManoel.CRUDCursos.modules.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listCourse")
public class CourseListController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<CoursesEntity> listAllCourse() {
        return courseService.ListCourse();

    }

    @GetMapping("/search")
    public List<CoursesEntity> listForName(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        return courseService.ListCourseNameCategory(name, category);
    }

}
