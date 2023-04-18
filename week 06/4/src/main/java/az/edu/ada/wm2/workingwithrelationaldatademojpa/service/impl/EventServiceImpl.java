package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.EventRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.EventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    EventRepository eventRepo;

    public EventServiceImpl(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<Event> list() {
        return (List<Event>) eventRepo.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event getById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        eventRepo.deleteById(id);
    }

    public List<Event> getAllWebEvents(String keyword) {
        return (List<Event>) eventRepo.getAllWebEventsUsingJPAQuery(keyword);
    }

}
