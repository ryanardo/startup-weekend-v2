package DAO;

import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Event_DAO_SQL2OTest {

    private Event_DAO_SQL2O event_DAO;
    private Attendee_DAO_SQL2O attendee_DAO;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        event_DAO = new Event_DAO_SQL2O(sql2o);
        attendee_DAO = new Attendee_DAO_SQL2O(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addEvent_CreatesInstance_true() throws Exception {
        Event event1 = new Event("title1", "description1");
        event_DAO.addEvent(event1);

        int originalIdEvent1 = event1.getIdEvent();
        assertNotEquals(originalIdEvent1, event1.getIdEvent());
    }

    @Test
    public void getAllEvents() throws Exception {
        Event event1 = new Event("title1", "description1");
        event_DAO.addEvent(event1);

        Event event2 = new Event("title1", "description2");
        event_DAO.addEvent(event2);

        assertEquals(2, event_DAO.getAllEvents().size());
    }

    @Test
    public void findByIdEvent() throws Exception {
        Event event1 = new Event("title1", "description1");
        event_DAO.addEvent(event1);

        Event event2 = new Event("title1", "description2");
        event_DAO.addEvent(event2);

        assertEquals(2, event_DAO.findByIdEvent(event2.getIdEvent()).getIdEvent());
    }

    @Test
    public void updateEvent() throws Exception {

    }

    @Test
    public void deleteByIdEvent() throws Exception {

    }

    @Test
    public void clearAllEvents() throws Exception {

    }

} /*END: Event_DAO_SQL2OTest*/
