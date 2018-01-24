package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Attendee_DAO_SQL2OTest {

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
    public void getAllAttendees() throws Exception {
    }

    @Test
    public void findByIdAttendee() throws Exception {
    }

    @Test
    public void updateAttendee() throws Exception {
    }

    @Test
    public void deleteByIdAttendee() throws Exception {
    }

    @Test
    public void clearAllAttendees() throws Exception {
    }

}