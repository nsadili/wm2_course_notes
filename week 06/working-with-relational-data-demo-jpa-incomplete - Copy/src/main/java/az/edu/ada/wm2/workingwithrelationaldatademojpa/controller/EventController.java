package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping({"", "/", "/list"})
    public String getEvents(Model model) {
        List<Event> events = eventService.list();
        model.addAttribute("events", events);

        LOGGER.info(events.toString());

        return "events/index";
    }

    @GetMapping("/new")
    public String createNewEvent(Model model) {
        model.addAttribute("event", new Event());
        return "events/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("event") Event event) {
        eventService.save(event);
        return "redirect:/event/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("event", eventService.getById(id));
        return "events/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        eventService.deleteById(id);
        return "redirect:/event/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateEvent(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("events/update");

        mv.addObject("event", eventService.getById(id));
        return mv;
    }

    @GetMapping("/filter/{keyword}")
    public String getWebEvents(Model model, @PathVariable String keyword){
        model.addAttribute("events", eventService.getAllWebEvents(keyword));

        return "events/index";
    }
}
