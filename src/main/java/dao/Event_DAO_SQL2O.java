package dao;

import models.Event;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Event_DAO_SQL2O implements Event_DAO {

    private final Sql2o sql2o;
    public Event_DAO_SQL2O(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addEvent(Event event) {
        String sql = "INSERT INTO events (eventTitle, eventDescription) VALUES (:eventTitle, :eventDescription)";
        try (Connection con = sql2o.open()) {
            int idEvent = (int) con.createQuery(sql)
                    .bind(event)
                    .executeUpdate()
                    .getKey();
            event.setIdEvent(idEvent);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM events";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Event.class);
        }
    }

    @Override
    public Event findByIdEvent(int idEvent) {
        String sql = "SELECT * FROM events WHERE idEvent = :idEvent";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idEvent", idEvent)
                    .executeAndFetchFirst(Event.class);
        }
    }

    @Override
    public void updateEvent(int idEvent, String eventTitle, String eventDescription) {
        String sql = "UPDATE events SET eventTitle = :eventTitle, eventDescription = :eventDescription WHERE idEvent = :idEvent";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("eventTitle", eventTitle)
                .addParameter("eventDescription", eventDescription)
                .addParameter("idEvent", idEvent)
                .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public void deleteByIdEvent(int idEvent) {
        String sql = "DELETE FROM events WHERE idEvent = :idEvent";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idEvent", idEvent)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllEvents() {
    }
} /*END: Event_DAO_SQL2O*/