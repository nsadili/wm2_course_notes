package az.edu.ada.wm2.lmsapp.controller;

import az.edu.ada.wm2.lmsapp.entity.Student;
import az.edu.ada.wm2.lmsapp.service.CourseService;
import az.edu.ada.wm2.lmsapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping({"", "/list"})
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page"})
    public String listStudents(Model model, @RequestParam Integer page) {
        model.addAttribute("students", studentService.getAllStudents(page));
        return "student/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page", "page-size"})
    public String listStudents(Model model,
                               @RequestParam Integer page,
                               @RequestParam(name = "page-size") Integer pageSize) {
        model.addAttribute("students", studentService.getAllStudents(page, pageSize));
        return "student/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page", "page-size", "sort"})
    public String listStudents(Model model,
                               @RequestParam Integer page,
                               @RequestParam(name = "page-size") Integer pageSize,
                               @RequestParam(name = "sort") String sortBy) {
        model.addAttribute("students", studentService.getAllStudents(page, pageSize, sortBy));
        return "student/list";
    }

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Integer id) {
        model.addAttribute("student", studentService.getById(id));
        return "student/detail";
    }

    @GetMapping("/create")
    public String createStudentView(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("/create")
    public String createStudentAction(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/{id}/update")
    public String updateStudentView(Model model, @PathVariable Integer id) {
        model.addAttribute("student", studentService.getById(id));
        return "student/update";
    }

    @PostMapping("/{id}/update")
    public String updateStudentAction(@PathVariable Integer id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentView(Model model, @PathVariable Integer id) {
        model.addAttribute("student", studentService.getById(id));
        return "student/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudentAction(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}
