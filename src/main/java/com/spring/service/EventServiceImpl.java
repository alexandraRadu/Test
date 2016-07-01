package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.exception.EventNotFound;
import com.spring.model.Event;
import com.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Resource
	private EventRepository eventRepository;

	@Transactional
	public Event create(Event event) {
		Event createdEvent = event;
		return eventRepository.save(createdEvent);
	}
	
	
	@Transactional
	public Event findById(int id) {
		return eventRepository.findOne(id);
	}

	
	@Transactional(rollbackFor=EventNotFound.class)
	public Event delete(int id) throws EventNotFound {
		Event deletedUser = eventRepository.findOne(id);
		
		if (deletedUser == null)
			throw new EventNotFound();
		
		eventRepository.delete(deletedUser);
		return deletedUser;
	}

	
	@Transactional
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Transactional(rollbackFor=EventNotFound.class)
	public Event update(Event event) throws EventNotFound {
		Event updatedEvent = eventRepository.findOne(event.getEventId());
		
		if (updatedEvent == null)
			throw new EventNotFound();
		
		updatedEvent.setTitle(event.getTitle());
		updatedEvent.setEventId(event.getEventId());
		return updatedEvent;
	}

}

