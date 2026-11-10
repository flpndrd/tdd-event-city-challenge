package com.devsuperior.tddeventcity.event.exception;

import java.io.Serial;

import com.devsuperior.tddeventcity.exception.InvalidRequestException;

public class InvalidEventCityException extends InvalidRequestException {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Event has a city that does not exist.";

	public InvalidEventCityException() {
		super(MESSAGE);
	}

}
