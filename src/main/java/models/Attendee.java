package models;

import java.util.ArrayList;
import java.util.Objects;

public class Attendee {

    private static ArrayList<Event> events = new ArrayList<>();
    private String attendeeName;
    private int idAttendee;
    private int eventId;

    //CONSTRUCTOR
    public Attendee(String attendeeName, int eventId) {
        this.attendeeName = attendeeName;
        this.eventId = eventId;
    }

    //GETTER
    public static ArrayList<Event> getEvents() {
        return events;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public int getIdAttendee() {
        return idAttendee;
    }

    public int getEventId() {
        return eventId;
    }

    //SETTER
    public static void setEvents(ArrayList<Event> events) {
        Attendee.events = events;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public void setIdAttendee(int idAttendee) {
        this.idAttendee = idAttendee;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    //EQUALS HASH CODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return idAttendee == attendee.idAttendee &&
                eventId == attendee.eventId &&
                Objects.equals(attendeeName, attendee.attendeeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(attendeeName, idAttendee, eventId);
    }
}
