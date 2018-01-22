package models;

import java.util.ArrayList;

public class Attendee {

    private static ArrayList<Event> events = new ArrayList<>();
    private String attendeeName;
    private Integer idAttendee;

    public Attendee(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void setEvents(ArrayList<Event> events) {
        Attendee.events = events;
    }

    //GETTER
    public String getAttendeeName() {
        return attendeeName;
    }

    //SETTER
    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public Integer getIdAttendee() {
        return idAttendee;
    }

    public void setIdAttendee(Integer idAttendee) {
        this.idAttendee = idAttendee;
    }

    //EQUALS HASH CODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attendee attendee = (Attendee) o;

        if (!attendeeName.equals(attendee.attendeeName)) return false;
        return idAttendee != null ? idAttendee.equals(attendee.idAttendee) : attendee.idAttendee == null;
    }

    @Override
    public int hashCode() {
        int result = attendeeName.hashCode();
        result = 31 * result + (idAttendee != null ? idAttendee.hashCode() : 0);
        return result;
    }
}
