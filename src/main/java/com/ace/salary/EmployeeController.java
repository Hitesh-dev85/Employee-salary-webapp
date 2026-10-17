package com.ace.salary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam String employeeId,
            @RequestParam String employeeName,
            @RequestParam double basicSalary,
            @RequestParam double hra,
            @RequestParam double otherAllowances,
            Model model) {

        double grossSalary = basicSalary + hra + otherAllowances;
        double annualSalary = grossSalary * 12;

        model.addAttribute("employeeId", employeeId);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("basicSalary", basicSalary);
        model.addAttribute("hra", hra);
        model.addAttribute("otherAllowances", otherAllowances);
        model.addAttribute("grossSalary", grossSalary);
        model.addAttribute("annualSalary", annualSalary);

        return "index";
    }
}
