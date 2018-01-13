import models.Event;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> events = Event.getInstances();
            model.put("post", events);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        // CREATE NEW EVENT
        get("/events/create", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());
        // CREATE NEW EVENT
        post("/events/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String eventTitle = request.queryParams("eventTitle");
            String eventDescription = request.queryParams("eventDescription");
            Event newEvent = new Event(eventTitle, eventDescription);
            model.put("event", newEvent);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        // GET EVENT DETAILS
//        get("/events", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "event-details.hbs")
//        });
    }
}
