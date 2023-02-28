package com.example.coursecrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table
@Entity
public class Course {
    @Id
    private Integer id;

    private String name;
    private String departmentName;
    private Integer credits;


    public Course() {
        this.id = UUID.randomUUID().version();
    }
}
