package dao;

import models.Event;

import java.util.List;

public interface Event_DAO {

    //CREATE
    void addEvent(Event event);

    //REVIEW
    Event findByIdEvent(int idEvent);
    List<Event> getAllEvents();

    //UPDATE
    void updateEvent(int idEvent, String eventTitle, String eventDescription);

    //DELETE
    void deleteByIdEvent(int idEvent);
    void clearAllEvents();
}