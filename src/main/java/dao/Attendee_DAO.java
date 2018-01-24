package dao;

import models.Attendee;
import models.Event;

import java.util.List;

public interface Attendee_DAO {

    //CREATE
    void addAttendee(Attendee attendee);


    //REVIEW
    Attendee findByIdAttendee(int idAttendee);
    List<Attendee> getAllAttendees();

    //UPDATE
    void updateAttendee(int idAttendee, String attendeeName);

    //DELETE
    void deleteByIdAttendee(int idAttendee);
    void clearAllAttendees();

}
