package com.spring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Serializable>{

}
