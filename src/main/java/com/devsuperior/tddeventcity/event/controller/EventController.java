package com.devsuperior.tddeventcity.event.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.tddeventcity.event.dto.EventDTO;
import com.devsuperior.tddeventcity.event.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@PutMapping("/{eventId}")
	ResponseEntity<EventDTO> update(@PathVariable Long eventId, @Valid @RequestBody EventDTO eventDTO) {
		EventDTO updatedEventDTO = eventService.update(eventId, eventDTO);
		return ResponseEntity.ok(updatedEventDTO);
	}

}
