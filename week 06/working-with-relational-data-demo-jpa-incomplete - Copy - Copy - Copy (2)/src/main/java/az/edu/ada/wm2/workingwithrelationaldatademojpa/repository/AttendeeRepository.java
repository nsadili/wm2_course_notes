package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Attendee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    Page<Attendee> findAll(Pageable pageable);

    Iterable<Attendee> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Attendee> findByFirstNameOrLastName(String firstName, String lastName);

}