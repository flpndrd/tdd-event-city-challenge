package com.devsuperior.tddeventcity.event.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.tddeventcity.city.entity.City;
import com.devsuperior.tddeventcity.city.repository.CityRepository;
import com.devsuperior.tddeventcity.event.dto.EventDTO;
import com.devsuperior.tddeventcity.event.entity.Event;
import com.devsuperior.tddeventcity.event.exception.EventNotFoundException;
import com.devsuperior.tddeventcity.event.exception.InvalidEventCityException;
import com.devsuperior.tddeventcity.event.repository.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepository;

	private final CityRepository cityRepository;

	public EventService(EventRepository eventRepository, CityRepository cityRepository) {
		this.eventRepository = eventRepository;
		this.cityRepository = cityRepository;
	}

	@Transactional
	public EventDTO update(Long eventId, EventDTO eventDTO) {
		Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException());
		City city = cityRepository.findById(eventDTO.cityId()).orElseThrow(() -> new InvalidEventCityException());
		event.setName(eventDTO.name());
		event.setDate(eventDTO.date());
		event.setUrl(eventDTO.url());
		event.setCity(city);
		return EventDTO.from(event);
	}

}
