package br.com.CarlosManoel.CRUDCursos.modules.courses.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroMessageDTO {

    private String message;
    private String field;
}
