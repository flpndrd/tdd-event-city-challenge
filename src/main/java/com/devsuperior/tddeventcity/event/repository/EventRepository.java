package com.devsuperior.tddeventcity.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.tddeventcity.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
