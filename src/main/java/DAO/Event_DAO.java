package DAO;

import models.Event;

import java.util.List;

public interface Event_DAO {

    void addEvent(Event event);
    List<Event> getAllEvents();
    Event findByIdEvent(int id);

    void updateEvent(int id, String eventTitle, String eventDescription);
    void deleteByIdEvent(int id);
    void clearAllEvents();

}