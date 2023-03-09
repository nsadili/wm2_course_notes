package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Integer id;
    private String courseName;
    private String departmentName;
    private Integer credits;

    public Course(String courseName, String departmentName, Integer credits) {
        this.courseName = courseName;
        this.departmentName = departmentName;
        this.credits = credits;
    }
}
