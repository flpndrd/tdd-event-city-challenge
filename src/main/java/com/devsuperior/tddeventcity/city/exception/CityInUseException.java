package com.devsuperior.tddeventcity.city.exception;

import java.io.Serial;

import com.devsuperior.tddeventcity.exception.BusinessRuleException;

public class CityInUseException extends BusinessRuleException {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "City cannot be deleted because it has events.";

	public CityInUseException() {
		super(MESSAGE);
	}

}
