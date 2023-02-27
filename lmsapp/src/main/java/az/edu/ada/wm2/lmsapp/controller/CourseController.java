package az.edu.ada.wm2.lmsapp.controller;

import az.edu.ada.wm2.lmsapp.entity.Course;
import az.edu.ada.wm2.lmsapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping(value = {"", "/list"})
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.listCourses());
        return "course/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page"})
    public String listCourses(Model model, @RequestParam Integer page) {
        model.addAttribute("courses", courseService.listCourses(page));
        return "course/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page", "page-size"})
    public String listCourses(Model model,
                              @RequestParam Integer page,
                              @RequestParam(name = "page-size") Integer pageSize) {
        model.addAttribute("courses", courseService.listCourses(page, pageSize));
        return "course/list";
    }

    @GetMapping(value = {"", "/list"}, params = {"page", "page-size", "sort"})
    public String listCourses(Model model,
                              @RequestParam Integer page,
                              @RequestParam(name = "page-size") Integer pageSize,
                              @RequestParam(name = "sort", required = false) String sortBy) {
        model.addAttribute("courses", courseService.listCourses(page, pageSize, sortBy));
        return "course/list";
    }

    @GetMapping("/{id}")
    public String getCourse(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/detail";
    }

    @GetMapping("/create")
    public String createCourseView(Model model) {
        model.addAttribute("course", new Course());
        return "course/create";
    }

    @PostMapping("/create")
    public String createCourseAction(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/courses/list";
    }

    @GetMapping("/{id}/update")
    public String updateCourseView(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/update";
    }

    @PostMapping("/{id}/update")
    public String updateCourseView(@PathVariable Integer id, @ModelAttribute Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/courses/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCourseView(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourseAction(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }
}
