package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {

    private static ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Attendee> attendees = new ArrayList<Attendee>();
    private String eventTitle;
    private String eventDescription;
    private LocalDateTime createdAt;
    private int idEvent;

    //CONSTRUCTOR
    public Event(String eventTitle, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void setEvents(ArrayList<Event> events) {
        Event.events = events;
    }

    //STATIC METHODS
    public static Event findEvent(int idEvent) {
        return events.get(idEvent - 1);
    }

    //GETTERS
    public ArrayList<Attendee> getAttendees() {
        return attendees;
    }

    //SETTERS
    public void setAttendees(ArrayList<Attendee> attendees) {
        this.attendees = attendees;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    //EQUALS HASH CODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (idEvent != event.idEvent) return false;
        if (attendees != null ? !attendees.equals(event.attendees) : event.attendees != null) return false;
        if (!eventTitle.equals(event.eventTitle)) return false;
        if (!eventDescription.equals(event.eventDescription)) return false;
        return createdAt != null ? createdAt.equals(event.createdAt) : event.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = attendees != null ? attendees.hashCode() : 0;
        result = 31 * result + eventTitle.hashCode();
        result = 31 * result + eventDescription.hashCode();
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idEvent;
        return result;
    }

    //INSTANCE METHODS
    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public void editEventTitle(String updatedEventTitle) {
        this.eventTitle = updatedEventTitle;
    }

    public void editEventDescription(String updatedEventDescription) {
        this.eventDescription = updatedEventDescription;
    }

}
