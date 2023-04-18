package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Attendee;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.EventService;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.AttendeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendee")
public class AttendeeController {
    static final Logger LOGGER = LoggerFactory.getLogger(AttendeeController.class);

    private AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping({"", "/", "/list"})
    public String getAttendees(Model model) {
        return getAttendeesByPageNo(model, 1);
    }

    @GetMapping("/page/{no}")
    public String getAttendeesByPageNo(Model model, @PathVariable("no") Integer pageNo) {
        Page<Attendee> attendeesPage = attendeeService.list(pageNo);

        model.addAttribute("attendees", attendeesPage.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", attendeesPage.getTotalPages());
        model.addAttribute("nbElements", attendeesPage.getNumberOfElements());
        model.addAttribute("totalElements", attendeesPage.getTotalElements());

        return "attendees/index";
    }

    @GetMapping("/new")
    public String createNewAttendee(Model model) {
        model.addAttribute("attendee", new Attendee());
        LOGGER.info("createNewAttendee()");
        return "attendees/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("attendee") Attendee attendee) {
        attendeeService.save(attendee);
        return "redirect:/attendee/";
    }

    @GetMapping("/{id}")
    public String getAttendee(Model model, @PathVariable Long id) throws Exception {
        model.addAttribute("attendee", attendeeService.getById(id));
        return "attendees/info";
    }

    @GetMapping("/and/{firstName}/{lastName}")
    public String getAttendeeByNameAnd(Model model, @PathVariable String firstName, @PathVariable String lastName) {

        var attendee = attendeeService.getAttendeeByNamesAnd(firstName, lastName);

        model.addAttribute("attendees", attendee);

        return "attendees/index";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getAttendeeByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        model.addAttribute("attendees", attendeeService.getAttendeeByNamesOr(firstName, lastName));

        return "attendees/index";
    }

    @GetMapping("/{id}/events")
    public String getEventsByAttendeeId(Model model, @PathVariable Long id) {
        model.addAttribute("events", attendeeService.getEventsByAttendeeId(id));
        return "events/index";
    }

    @GetMapping("/{id}/addEvent")
    public String addEventPage(Model model, @PathVariable Long id) {

        Attendee stud = attendeeService.getById(id);
        model.addAttribute("attendee", stud);

        List<Event> allEvents = attendeeService.getEventsByAttendeeIdNot(id);
        model.addAttribute("events", allEvents);
        return "attendees/add_course";
    }
}