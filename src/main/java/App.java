import jdk.internal.org.objectweb.asm.Handle;
import models.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

    //HOME PAGE
    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        ArrayList<Event> events = Event.getEvents();
        model.put("events", events);
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());

    //GET: CREATE EVENT PAGE
    get("/events/create", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        /*LOGIC_FOR_GET_AND_POST*/
        return new ModelAndView(model, "event-form.hbs");
    }, new HandlebarsTemplateEngine());

    //POST: CREATE EVENT PAGE
    post("/events/create", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String newEventTitle = request.queryParams("eventTitle");
        String newEventDescription = request.queryParams("eventDescription");
        Event newEvent = new Event(newEventTitle, newEventDescription);
        return new ModelAndView(model, "event-form.hbs");
    }, new HandlebarsTemplateEngine());

    //GET: EVENT DETAILS
    get("/events/:idEvent", (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        Integer selectedEventId = Integer.parseInt(request.params("idEvent"));
        Event selectedEvent = Event.findEvent(selectedEventId);
        model.put("event", selectedEvent);
        return new ModelAndView(model, "event-details.hbs");
    }, new HandlebarsTemplateEngine());

    //POST: ADD NEW ATTENDEES
    post("/events/:idEvent/attendee/new", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String newAttendeeName = request.queryParams("attendee-name");
        Attendee attendee = new Attendee(newAttendeeName);
        Integer idEventAttending = Integer.parseInt(request.params("idEvent"));
        Event eventAttending = Event.findEvent(idEventAttending);
        eventAttending.addAttendee(attendee);
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());

    } //PSVM
} //APP
