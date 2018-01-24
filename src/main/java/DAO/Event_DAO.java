package DAO;

import models.Event;

import java.util.List;

public interface Event_DAO {

    void addEvent(Event event);
    List<Event> getAllEvents();
    Event findByIdEvent(int idEventv);

    void updateEvent(int idEvent, String eventTitle, String eventDescription);
    void deleteByIdEvent(int idEvent);
    void clearAllEvents();

}