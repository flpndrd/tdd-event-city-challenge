package com.devsuperior.tddeventcity.city.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.tddeventcity.city.dto.CityDTO;
import com.devsuperior.tddeventcity.city.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

	@Query("""
			SELECT new com.devsuperior.tddeventcity.city.dto.CityDTO(city.cityId, city.name)
			FROM City city
			ORDER BY city.name
			""")
	List<CityDTO> listAll();

	@Query("""
			SELECT COUNT(event) > 0
			FROM Event event
			WHERE event.city.cityId = :cityId
			""")
	boolean existsWithEvents(Long cityId);

}
