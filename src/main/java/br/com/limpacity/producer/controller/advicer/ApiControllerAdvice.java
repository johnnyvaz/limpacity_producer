package br.com.limpacity.producer.controller.advicer;

import br.com.limpacity.producer.controller.base.ResponseBodyDTO;
import br.com.limpacity.producer.controller.base.error.ErrorCodeEnum;
import br.com.limpacity.producer.controller.base.error.ErrorDTO;
import br.com.limpacity.producer.controller.base.error.ErrorDTOFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;


@SuppressWarnings("rawtypes")
@Slf4j
@ControllerAdvice
public class ApiControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler({HibernateException.class})
    public ResponseEntity handleHibernateException(HibernateException ex) {

        log.error("Hibernate {} " , ex.getMessage());
        ErrorDTO errorDto = ErrorDTOFactory.getInternalServerError(ex.getMessage())	;
        return ResponseEntity.status(Objects.requireNonNull(
                ErrorCodeEnum.findHttpStatus(errorDto.getErrorCode())))
                .body(ResponseBodyDTO.with(errorDto));
    }

    private ResponseEntity<?> buildResponseNotFound(String info) {
        return ResponseEntity.status(ErrorCodeEnum.NOT_FOUND.getHttpCode())
                .body(ErrorDTOFactory.getNotFound(info));
    }

}