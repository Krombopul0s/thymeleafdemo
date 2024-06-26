package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    /*
    This @Value annotation will inject data from application.properties file. The reference tells it what data to use.
    Our list will be split on the commas and injected.
     */
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        //create Student object
        Student theStudent = new Student ();

        //add student object to the model
        theModel.addAttribute("student", new Student());

        //add the list of countries to the model
        theModel.addAttribute("countries", countries);

        //add the list of languages to the model
        theModel.addAttribute("languages", languages);

        //add the list of OS's to the model
        theModel.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        //log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}
