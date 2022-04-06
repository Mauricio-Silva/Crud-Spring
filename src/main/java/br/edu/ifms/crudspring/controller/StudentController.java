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


    @GetMapping("/listAll")
    public String listAllStudents(Model html) {
        List<Student> studentsList = studentService.getAllStudents();
        html.addAttribute("studentsList", studentsList);
        html.addAttribute("studentUpdate", new Student());
        return "studentListAll";
    }


    @GetMapping("/register")
    public String studanteResister(Model html) {
        html.addAttribute("studentResister", new Student());
        return "studentRegister";
    }


    @PostMapping("/save")
    public String studentSave(@ModelAttribute("studentResister") Student studentFromRegister) {
        studentService.saveStudent(studentFromRegister);
        return "redirect:/student/listAll";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/listAll";
    }


    @GetMapping("/select/{id}")
    public String selectStudent(@PathVariable("id") UUID id, Model html) {
        Student studentForUpdate = studentService.getStudentById(id);
        studentForUpdate.setPassword(studentForUpdate.getPassword());
        html.addAttribute("studentUpdate", studentForUpdate);
        return "redirect:/student/listAll";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute("studentUpdate") Student studentFromUpdate) {
        // Student studentForUpdate = studentService.getStudentById(id);
        // studentForUpdate.setName(studentFromUpdate.getName());
        // studentForUpdate.setEmail(studentFromUpdate.getEmail());
        // studentForUpdate.setPassword(studentFromUpdate.getPassword());
        // studentService.saveStudent(studentFromUpdate);
        return "redirect:/student/listAll";
    }
}
