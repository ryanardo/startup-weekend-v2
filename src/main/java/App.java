import dao.Attendee_DAO;
import dao.Attendee_DAO_SQL2O;
import dao.Event_DAO;
import dao.Event_DAO_SQL2O;
import models.Attendee;
import models.Event;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:mem:startupweekend;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Event_DAO eventDao = new Event_DAO_SQL2O(sql2o);
        Attendee_DAO attendeeDao= new Attendee_DAO_SQL2O(sql2o);

        //HOME PAGE
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            List<Event> events = eventDao.getAllEvents();

            model.put("events", events);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //GET: CREATE EVENT PAGE
        get("/events/create", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        //GET: EVENT DETAILS
        get("/events/:idEvent", (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();

            Integer selectedEventId = Integer.parseInt(request.params("idEvent"));
            Event selectedEvent = eventDao.findByIdEvent(selectedEventId);

            model.put("event", selectedEvent);
            return new ModelAndView(model, "event-details.hbs");
        }, new HandlebarsTemplateEngine());

        //GET: UPDATE EVENT DETAILS
        get("/events/:idEvent/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Integer idEventToUpdate = Integer.parseInt(request.params("idEvent"));
            Event updateEvent = eventDao.findByIdEvent(idEventToUpdate);

            model.put("updateEvent", updateEvent);
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        //POST: POST UPDATED EVENT DETAILS
        post("/events/:idEvent/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String updatedEventTitle = request.queryParams("event-title");
            String updatedEventDescription = request.queryParams("event-description");
            Integer updatedEventId = Integer.parseInt(request.params("idEvent"));
            eventDao.updateEvent(updatedEventId, updatedEventTitle, updatedEventDescription);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //POST: ADD NEW ATTENDEES
        post("/events/:idEvent/attendee/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String newAttendeeName = request.queryParams("attendee-name");
            Attendee newAttendee = new Attendee(newAttendeeName);
            attendeeDao.addAttendee(newAttendee);

            Integer idEventAttending = Integer.parseInt(request.params("idEvent"));
            Event eventAttending = Event.findEvent(idEventAttending);
            eventAttending.addAttendee(newAttendee);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //POST: CREATE EVENT PAGE
        post("/events/create", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newEventTitle = request.queryParams("event-title");
            String newEventDescription = request.queryParams("event-description");
            Event newEvent = new Event(newEventTitle, newEventDescription);
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
