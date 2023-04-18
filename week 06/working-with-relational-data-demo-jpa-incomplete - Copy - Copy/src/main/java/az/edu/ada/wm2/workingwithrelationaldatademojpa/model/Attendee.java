package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ATTENDEES")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "attendee_event",
            joinColumns = {@JoinColumn(name = "attendee_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private Set<Event> events = new HashSet<>();

    @Override
    public String toString() {
        return "Attendee: " + firstName + ", " + lastName;
    }
}
