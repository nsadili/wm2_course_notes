package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Attendee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AttendeeService {

    Page<Attendee> list(int pageNo);

    Attendee save(Attendee attendee);

    Attendee getById(Long id);

    List<Attendee> getAttendeeByNamesAnd(String firstName, String lastName);

    List<Attendee> getAttendeeByNamesOr(String firstName, String lastName);

    List<Event> getEventsByAttendeeId(Long id);

    List<Event> getEventsByAttendeeIdNot(Long id);
}
