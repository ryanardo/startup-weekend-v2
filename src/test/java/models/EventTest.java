package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class EventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEvent_instantiatesCorrectly() throws Exception {
        Event testEvent = new Event("event-a","description-a");
        assertEquals(true, testEvent instanceof Event);
    }

    @Test
    public void testEvent_getEventTitle() {
        Event testEvent = new Event("event-a","description-a");
        assertEquals("event-a", testEvent.getEventTitle());
    }

    @Test
    public void testEvent_getEventDesccription() {
        Event testEvent = new Event("event-a","description-a");
        assertEquals("description-a", testEvent.getEventDescription());
    }
}