package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> list();

    Event save(Event event);

    Event getById(Long id);

    void deleteById(Long id);

    List<Event> getAllWebEvents(String keyword);

//    List<Event> findByStudentsId(Long id);
}
