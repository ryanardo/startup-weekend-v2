package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/19/18.
 */
public class EventTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstances() throws Exception {
        Event testEvent = new Event("Title-1.0", "Description-1.0");
        assertEquals(true, testEvent instanceof Event);
    }

    @Test
    public void getAttendees() throws Exception {

    }

    @Test
    public void getEventTitle() throws Exception {

    }

    @Test
    public void getEventDescription() throws Exception {

    }

    @Test
    public void getCreatedAt() throws Exception {

    }

    @Test
    public void getIdEvent() throws Exception {

    }

    @Test
    public void addAttendee() throws Exception {
        Event testEvent = new Event("Title-1.0", "Description-1.0");
        Attendee attendee1 = new Attendee("attendee1");
        Attendee attendee2 = new Attendee("attendee2");
        Attendee attendee3 = new Attendee("attendee3");
        Attendee attendee4 = new Attendee("attendee4");
        testEvent.addAttendee(attendee1);
        testEvent.addAttendee(attendee2);
        testEvent.addAttendee(attendee3);
        testEvent.addAttendee(attendee4);
        assertEquals(4, testEvent.getAttendees().size());
    }

}