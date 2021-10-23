package com.pakie.flymzansi_ato_manager.common_objects.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    //List Courses
    @GetMapping("/courses")
    //public String courses(){
    public String getAllCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course/courses";
    }

    @GetMapping("/courses/add-course")
    public String addCourse(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/add_course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
    @GetMapping("/courses/update-course/{id}")
    public String updateCourse(@PathVariable(value = "id") Long id, Model model){
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);

        return "course/update_course";
    }
    @GetMapping("/courses/delete-course/{id}")
    public String deleteCourse(@PathVariable(value = "id") Long id, Model model){
        this.courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}
