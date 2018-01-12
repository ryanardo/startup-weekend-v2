package models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Event {

    private String eventTitle;
    private String eventDescription;
    private static ArrayList<Event> instances = new ArrayList<>();
    private List<String> eventAttendees = new ArrayList<String>();
    private LocalDateTime createdAt;
    private int id;

    public Event(String eventTitle, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id =  instances.size();
    }
} // End of 'Event.java'