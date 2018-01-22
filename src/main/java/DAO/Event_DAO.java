package DAO;
import models.*;
import java.util.List;

public interface Event_DAO {

    List<Event> getAllEvents();
    Event findByIdEvent(int id);
    void updateEvent(int id, String comment);
    void deleteByIdEvent(int id);
    void clearAllEvents();

}
