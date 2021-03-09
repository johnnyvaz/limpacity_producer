package br.com.limpacity.producer.controller.base.error;

import org.springframework.validation.FieldError;

public interface HandleValidationType {
    ErrorDTO create(FieldError var1);
}
