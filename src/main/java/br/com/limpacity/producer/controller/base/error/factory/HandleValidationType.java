package br.com.limpacity.producer.controller.base.error.factory;

import br.com.limpacity.producer.controller.base.error.ErrorDTO;
import org.springframework.validation.FieldError;

public interface HandleValidationType {
    ErrorDTO create(FieldError fieldError);
}
