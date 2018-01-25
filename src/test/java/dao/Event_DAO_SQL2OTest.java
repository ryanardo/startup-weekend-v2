package dao;

import models.Attendee;
import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;

public class Event_DAO_SQL2OTest {

    private Event_DAO_SQL2O daoEvent;
    private Attendee_DAO_SQL2O daoAttendee;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        daoEvent = new Event_DAO_SQL2O(sql2o);
        daoAttendee = new Attendee_DAO_SQL2O(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addEvent() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);

        assertEquals(1, event1.getIdEvent());
    }

    @Test
    public void getAllEvents() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);

        assertEquals(2, daoEvent.getAllEvents().size());
    }

    @Test
    public void getAllAttendeesByEvent() {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);

        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        Attendee attendee2 = new Attendee("Patrick Star", 1);
        daoAttendee.addAttendee(attendee2);

        Attendee attendee3 = new Attendee("Sandy Cheeks", 2);
        daoAttendee.addAttendee(attendee3);

        assertEquals(1, daoEvent.getAllAttendeesByEvent(2).size());
    }

    @Test
    public void findByIdEvent() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);

        assertEquals(2, daoEvent.findByIdEvent(event2.getIdEvent()).getIdEvent());
    }

    @Test
    public void updateEvent() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);
        int idEvent1 = event1.getIdEvent();
        daoEvent.updateEvent(idEvent1, "title1.1", "description1.1");

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);

        assertEquals("title1.1", daoEvent.findByIdEvent(idEvent1).getEventTitle());
    }

    @Test
    public void deleteByIdEvent() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);
        int idEvent1 = event1.getIdEvent();

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);
        int idEvent2 = event2.getIdEvent();

        daoEvent.deleteByIdEvent(idEvent2);

        assertEquals(1, daoEvent.getAllEvents().size());
    }

    @Test
    public void clearAllEvents() throws Exception {
        Event event1 = new Event("title1", "description1");
        daoEvent.addEvent(event1);
        int idEvent1 = event1.getIdEvent();

        Event event2 = new Event("title2", "description2");
        daoEvent.addEvent(event2);
        int idEvent2 = event2.getIdEvent();

        daoEvent.clearAllEvents();

        assertEquals(0, daoEvent.getAllEvents().size());
    }

}