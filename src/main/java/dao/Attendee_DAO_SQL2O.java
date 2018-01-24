package dao;

import models.Attendee;
import models.Event;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Attendee_DAO_SQL2O implements Attendee_DAO {

    private final Sql2o sql2o;
    public Attendee_DAO_SQL2O(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addAttendee(Attendee attendee) {
        String sql = "INSERT INTO attendees (attendeeName) VALUES (:attendeeName)";
        try (Connection con = sql2o.open()) {
            int idAttendee = (int) con.createQuery(sql)
                    .bind(attendee)
                    .executeUpdate()
                    .getKey();
            attendee.setIdAttendee(idAttendee);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Event findByIdAttendee(int idAttendee) {
        return null;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return null;
    }

    @Override
    public void updateAttendee(int idAttendee, String comment) {

    }

    @Override
    public void deleteByIdAttendee(int idAttendee) {

    }

    @Override
    public void clearAllAttendees() {

    }
}
