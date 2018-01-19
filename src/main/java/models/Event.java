package models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Event {

    private ArrayList<Attendee> attendees = new ArrayList<Attendee>();
    private static ArrayList<Event> instances = new ArrayList<>();
    private String eventTitle;
    private String eventDescription;
    private LocalDateTime createdAt;
    private int idEvent;

    public Event(String eventTitle, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.idEvent = instances.size();
    }
    //GETTERS
    public ArrayList<Attendee> getAttendees() {
        return attendees;
    }

    public static ArrayList<Event> getInstances() {
        return instances;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getIdEvent() {
        return idEvent;
    }

    //INSTANCE METHODS
    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }
} // End of 'Event.java'