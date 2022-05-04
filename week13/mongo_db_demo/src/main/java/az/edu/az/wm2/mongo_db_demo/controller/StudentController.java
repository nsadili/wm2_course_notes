package az.edu.az.wm2.mongo_db_demo.controller;

import az.edu.az.wm2.mongo_db_demo.dto.StudentDto;
import az.edu.az.wm2.mongo_db_demo.dto.StudentSummaryDto;
import az.edu.az.wm2.mongo_db_demo.entity.Student;
import az.edu.az.wm2.mongo_db_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService stdService;

    @GetMapping("/")
    public List<StudentSummaryDto> getAllStudents() {
        return stdService.getAllStudents();
    }

    @GetMapping("/{min}/{max}")
    public List<Student> getAllStudents(@PathVariable Double min, @PathVariable Double max) {
        return stdService.getAllStudentsWithGradeBetween(min, max);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSummaryDto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(stdService.getStudentById(id));
    }

    @PostMapping("/")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(stdService.save(studentDto), HttpStatus.CREATED);
    }
}
