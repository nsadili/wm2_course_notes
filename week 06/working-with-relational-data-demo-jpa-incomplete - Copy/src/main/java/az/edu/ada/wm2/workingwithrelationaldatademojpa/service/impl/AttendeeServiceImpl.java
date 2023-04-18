package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Attendee;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.EventRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.AttendeeRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.AttendeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    private AttendeeRepository attendeeRepo;

    private EventRepository eventRepo;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepo, EventRepository eventRepo) {
        this.attendeeRepo = attendeeRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public Page<Attendee> list(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return attendeeRepo.findAll(pageable);
    }

    @Override
    public Attendee save(Attendee attendee) {
        return attendeeRepo.save(attendee);
    }

    @Override
    public Attendee getById(Long id) {
        return attendeeRepo.findById(id).orElse(null);
    }

    public List<Attendee> getAttendeeByNamesAnd(String firstName, String lastName) {
        return (List<Attendee>) attendeeRepo.findByFirstNameAndLastName(firstName, lastName);

    }

    public List<Attendee> getAttendeeByNamesOr(String firstName, String lastName) {
        return (List<Attendee>) attendeeRepo.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Event> getEventsByAttendeeId(Long id) {
        return (List<Event>) eventRepo.findByAttendeesId(id);
    }

    @Override
    public List<Event> getEventsByAttendeeIdNot(Long id) {
        return (List<Event>) eventRepo.findByAttendeesIdNot(id);
    }
}
