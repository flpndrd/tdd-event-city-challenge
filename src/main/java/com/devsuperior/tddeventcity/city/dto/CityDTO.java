package com.devsuperior.tddeventcity.city.dto;

import com.devsuperior.tddeventcity.city.entity.City;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CityDTO(
		@JsonProperty("id")
		Long cityId,
		String name) {

	public static CityDTO from(City city) {
		return new CityDTO(city.getCityId(), city.getName());
	}

}
