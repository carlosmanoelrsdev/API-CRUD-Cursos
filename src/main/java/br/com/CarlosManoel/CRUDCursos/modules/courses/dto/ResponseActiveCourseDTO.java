package br.com.CarlosManoel.CRUDCursos.modules.courses.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseActiveCourseDTO {
        private UUID id;
        private String name;
        private String category;
        private Boolean active;
}

