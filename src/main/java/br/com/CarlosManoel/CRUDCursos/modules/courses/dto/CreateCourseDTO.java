package br.com.CarlosManoel.CRUDCursos.modules.courses.dto;

import lombok.Data;

@Data
public class CreateCourseDTO {

    private String name;
    private String category;
    private String teacher;
}
