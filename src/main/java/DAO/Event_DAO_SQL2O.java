package DAO;

import models.*;
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
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public Event findByIdEvent(int id) {
        return null;
    }

    @Override
    public void updateEvent(int id, String comment) {

    }

    @Override
    public void deleteByIdEvent(int id) {

    }

    @Override
    public void clearAllEvents() {

    }
} /*END: Event_DAO_SQL2O*/