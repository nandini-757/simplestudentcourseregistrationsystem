package com.example.student_course_registration.controller;


import com.example.student_course_registration.model.Admin;
import com.example.student_course_registration.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @GetMapping("/login")
    public String showLoginForm() {
        return "admin-login"; // JSP page
    }
    @GetMapping("/test")
    public String testJsp() {
        return "test";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        Admin admin = adminRepo.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin.getUsername());
            return "redirect:/admin/dashboard";
        }
        return "admin-login"; // back to login if invalid
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }
        return "admin-dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}