package dao;

import models.Attendee;
import models.Event;
import org.sql2o.Sql2o;

import java.util.List;

public class Attendee_DAO_SQL2O implements Attendee_DAO {

    private final Sql2o sql2o;
    public Attendee_DAO_SQL2O(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return null;
    }

    @Override
    public Event findByIdAttendee(int id) {
        return null;
    }

    @Override
    public void updateAttendee(int id, String comment) {

    }

    @Override
    public void deleteByIdAttendee(int id) {

    }

    @Override
    public void clearAllAttendees() {

    }
}
