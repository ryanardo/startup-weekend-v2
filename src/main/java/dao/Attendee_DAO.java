package dao;

import models.Attendee;

import java.util.List;

public interface Attendee_DAO {

    //CREATE
    void addAttendee(Attendee attendee);

    //REVIEW
    Attendee findByIdAttendee(int idAttendee);
    List<Attendee> getAllAttendees();
//    List<Attendee> getAllAttendeesByEvent(int eventId);

    //UPDATE
    void updateAttendee(int idAttendee, String attendeeName);

    //DELETE
    void deleteByIdAttendee(int idAttendee);
    void clearAllAttendees();
}