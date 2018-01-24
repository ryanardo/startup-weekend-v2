package dao;

import models.Attendee;
import models.Event;

import java.util.List;

public interface Attendee_DAO {

    List<Attendee> getAllAttendees();
    Event findByIdAttendee(int id);
    void updateAttendee(int id, String comment);
    void deleteByIdAttendee(int id);
    void clearAllAttendees();

}
