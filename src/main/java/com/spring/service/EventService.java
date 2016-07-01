package com.spring.service;

import java.util.List;

import com.spring.exception.EventNotFound;
import com.spring.model.Event;

public interface EventService {

	public Event create(Event event);
	public Event delete(int id) throws EventNotFound;
	public List<Event> findAll();
	public Event update(Event event) throws EventNotFound;
	public Event findById(int id);
}
