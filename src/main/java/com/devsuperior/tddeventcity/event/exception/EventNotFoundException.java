package com.devsuperior.tddeventcity.event.exception;

import java.io.Serial;

import com.devsuperior.tddeventcity.exception.ResourceNotFoundException;

public class EventNotFoundException extends ResourceNotFoundException {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Event not found.";

	public EventNotFoundException() {
		super(MESSAGE);
	}

}
