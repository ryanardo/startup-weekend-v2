package DAO;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

public class Event_DAO_SQL2OTest {

    private Event_DAO_SQL2O location_DAO;
    private Attendee_DAO_SQL2O review_DAO;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        location_DAO = new Event_DAO_SQL2O(sql2o);
        review_DAO = new Attendee_DAO_SQL2O(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void createEvent_true() throws Exception {
    }

    @Test
    public void getAllEvents() throws Exception {
    }

    @Test
    public void findByIdEvent() throws Exception {
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