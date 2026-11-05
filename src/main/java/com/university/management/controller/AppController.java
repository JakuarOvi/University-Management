package com.university.management.controller;

import com.university.management.model.LoginForm;
import com.university.management.model.Student;
import com.university.management.model.Teacher;
import com.university.management.service.UniversityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
    private final UniversityService universityService;

    public AppController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm,
                        RedirectAttributes redirectAttributes,
                        HttpSession session) {
        if (universityService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            session.setAttribute("username", loginForm.getUsername());
            return "redirect:/dashboard";
        }

        redirectAttributes.addFlashAttribute("error", "Invalid username or password");
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        model.addAttribute("studentCount", universityService.getStudentCount());
        model.addAttribute("teacherCount", universityService.getTeacherCount());
        model.addAttribute("username", session.getAttribute("username"));
        return "dashboard";
    }

    @GetMapping("/students")
    public String students(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        model.addAttribute("students", universityService.getStudents());
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student") Student student, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        universityService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/teachers")
    public String teachers(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        model.addAttribute("teachers", universityService.getTeachers());
        model.addAttribute("teacher", new Teacher());
        return "teachers";
    }

    @PostMapping("/teachers")
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        universityService.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
