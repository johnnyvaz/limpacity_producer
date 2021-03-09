package br.com.limpacity.producer.controller.base.error.factory;

import br.com.limpacity.producer.controller.base.error.ErrorDTO;
import br.com.limpacity.producer.controller.base.error.ErrorDTOFactory;
import org.springframework.validation.FieldError;


public class NotEmptyValidation implements HandleValidationType {

	@Override
	public ErrorDTO create(FieldError fieldError) {
		return ErrorDTOFactory.getMissingParameter("value", fieldError.getField());
	}

}
