package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

    Iterable<Event> findByAttendeesId(Long id);

    @Query("select e from Event e where e not in " +
            "(select e from Event e left join e.attendees std where std.id = :id)")
    Iterable<Event> findByAttendeesIdNot(Long id);

    @Query("select e from Event e where lower(e.description) like %:keyword%")
    Iterable<Event> getAllWebEventsUsingJPAQuery(@Param("keyword") String keyword);

    @Query(value = "select * from events where description like '%Web%'", nativeQuery = true)
    Iterable<Event> getAllWebCoursesUsingNativeQuery();
}