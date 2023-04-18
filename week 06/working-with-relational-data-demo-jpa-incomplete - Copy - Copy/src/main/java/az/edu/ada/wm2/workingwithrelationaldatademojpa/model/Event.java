package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.controller.AttendeeController;
import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "events")
    private Set<Attendee> attendees = new HashSet<>();

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Event(String name) {
        this(name, name);
    }

    @Override
    public String toString() {
        return "Event: " + this.name + ": " + this.description;
    }
}