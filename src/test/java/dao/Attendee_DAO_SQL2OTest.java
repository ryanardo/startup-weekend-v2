package dao;

import models.Attendee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;

public class Attendee_DAO_SQL2OTest {

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
    public void addAttendee() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        assertEquals(1, attendee1.getIdAttendee());
    }

    @Test
    public void findByIdAttendee() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        Attendee attendee2 = new Attendee("Patrick Star", 1);
        daoAttendee.addAttendee(attendee2);

        assertEquals(2, daoAttendee.findByIdAttendee(attendee2.getIdAttendee()).getIdAttendee());
    }

    @Test
    public void getAllAttendees() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        Attendee attendee2 = new Attendee("Patrick Star", 1);
        daoAttendee.addAttendee(attendee2);

        assertEquals(2, daoAttendee.getAllAttendees().size());
    }

    @Test
    public void updateAttendee() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        int idAttendee1 = attendee1.getIdAttendee();
        daoAttendee.updateAttendee(idAttendee1, "Spongebob");

        assertEquals("Spongebob", daoAttendee.findByIdAttendee(idAttendee1).getAttendeeName());
    }

    @Test
    public void deleteByIdAttendee() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        Attendee attendee2 = new Attendee("Patrick Star", 1);
        daoAttendee.addAttendee(attendee2);

        int idAttendee2 = attendee2.getIdAttendee();
        daoAttendee.deleteByIdAttendee(idAttendee2);

        assertEquals(1, daoAttendee.getAllAttendees().size());
    }

    @Test
    public void clearAllAttendees() {
        Attendee attendee1 = new Attendee("Spongebob Square Pants", 1);
        daoAttendee.addAttendee(attendee1);

        Attendee attendee2 = new Attendee("Patrick Star", 1);
        daoAttendee.addAttendee(attendee2);

        daoAttendee.clearAllAttendees();

        assertEquals(0, daoAttendee.getAllAttendees().size());
    }
}