package br.com.limpacity.producer.controller.advicer;

import br.com.limpacity.producer.controller.base.error.ErrorCodeEnum;
import br.com.limpacity.producer.controller.base.error.ErrorDTOFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@SuppressWarnings("rawtypes")
@Slf4j
@ControllerAdvice
public class ApiControllerAdvice extends BaseControllerAdvice {


    private ResponseEntity<?> buildResponseNotFound(String info) {
        return ResponseEntity.status(ErrorCodeEnum.NOT_FOUND.getHttpCode())
                .body(ErrorDTOFactory.getNotFound(info));
    }

}