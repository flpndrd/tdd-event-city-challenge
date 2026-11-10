package com.devsuperior.tddeventcity.event.dto;

import java.time.LocalDate;

import com.devsuperior.tddeventcity.event.entity.Event;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record EventDTO(
		@JsonProperty("id")
		Long eventId,
		String name,
		LocalDate date,
		String url,
		@NotNull(message = "City id is required")
		Long cityId) {

	public static EventDTO from(Event event) {
		return new EventDTO(
				event.getEventId(),
				event.getName(),
				event.getDate(),
				event.getUrl(),
				event.getCity().getCityId());
	}

}
