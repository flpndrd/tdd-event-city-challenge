package com.devsuperior.tddeventcity.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.tddeventcity.city.dto.CityDTO;
import com.devsuperior.tddeventcity.city.entity.City;
import com.devsuperior.tddeventcity.city.exception.CityInUseException;
import com.devsuperior.tddeventcity.city.exception.CityNotFoundException;
import com.devsuperior.tddeventcity.city.repository.CityRepository;

@Service
public class CityService {

	private final CityRepository cityRepository;

	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Transactional(readOnly = true)
	public List<CityDTO> list() {
		return cityRepository.listAll();
	}

	@Transactional
	public CityDTO create(CityDTO cityDTO) {
		City savedCity = cityRepository.save(new City(cityDTO.name()));
		return CityDTO.from(savedCity);
	}

	@Transactional
	public void delete(Long cityId) {
		if (!cityRepository.existsById(cityId)) {
			throw new CityNotFoundException();
		}

		if (cityRepository.existsWithEvents(cityId)) {
			throw new CityInUseException();
		}
		cityRepository.deleteById(cityId);
	}

}
