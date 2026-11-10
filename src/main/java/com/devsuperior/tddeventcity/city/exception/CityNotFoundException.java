package com.devsuperior.tddeventcity.city.exception;

import java.io.Serial;

import com.devsuperior.tddeventcity.exception.ResourceNotFoundException;

public class CityNotFoundException extends ResourceNotFoundException {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "City not found.";

	public CityNotFoundException() {
		super(MESSAGE);
	}

}
