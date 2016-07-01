package com.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Event;
import com.spring.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Event>> getEvents(){
		Collection<Event> events = eventService.findAll();
		return new ResponseEntity<Collection<Event>>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createEvent(@RequestBody Event event){
		eventService.create(event);
	}
}
