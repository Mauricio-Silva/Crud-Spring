package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/main")
    public String listAllStudents(Model html) {
        List<Student> studentsList = studentService.getAllStudents();
        html.addAttribute("studentsList", studentsList);
        html.addAttribute("noDataStudent", new Student());
        return "studentMain";
    }


    @PostMapping("/save")
    public String studentSave(@ModelAttribute("noDataStudent") Student studentFromRegister) {
        studentService.saveStudent(studentFromRegister);
        return "redirect:/student/main";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/main";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute("noDataStudent") Student studentFromUpdate) {
        studentService.saveStudent(studentFromUpdate);
        return "redirect:/student/main";
    }
}
