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

import br.edu.ifms.crudspring.model.Teacher;
import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.service.TeacherService;
import br.edu.ifms.crudspring.service.TurmaService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;

    @Autowired
    TurmaService turmaService;


    @GetMapping("/main")
    public String listAllTeachers(Model html) {
        List<Teacher> teachersList = teacherService.getAllTeachers();
        html.addAttribute("teachersList", teachersList);
        html.addAttribute("noDataTeacher", new Teacher());
        List<Turma> turmasList = turmaService.getAllTurmas();
        html.addAttribute("turmasList", turmasList);
        return "teacherMain";
    }


    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("noDataTeacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher/main";
    }


    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") UUID id) {
        teacherService.deleteTeacherById(id);
        return "redirect:/teacher/main";
    }


    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") UUID id, @ModelAttribute("noDataTeacher") Teacher teacherFromUpdate) {
        // teacherService.saveTeacher(teacherFromUpdate);
        return "redirect:/teacher/main";
    }
}
