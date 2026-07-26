package br.com.CarlosManoel.CRUDCursos.modules.courses.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseDeleteCourseDTO {

    private UUID id;
    private String name;
    private String category;
}
