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

import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.service.TurmaService;

@Controller
@RequestMapping("/turma")
public class TurmaController {
    
    @Autowired
    TurmaService turmaService;


    @GetMapping("/main")
    public String listAllTurmas(Model html) {
        List<Turma> turmaList = turmaService.getAllTurmas();
        html.addAttribute("turmaList", turmaList);
        html.addAttribute("noDataTurma", new Turma());
        return "turmaMain";
    }


    @GetMapping("/save")
    public String turmaSave(@ModelAttribute("noDataTurma") Turma turmaFromRegister) {
        turmaService.saveTurma(turmaFromRegister);
        return "redirect:/turma/main";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        turmaService.deleteTurmaById(id);
        return "redirect:/turma/main";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute("noDataStudent") Turma turmaFromUpdate) {
        turmaService.saveTurma(turmaFromUpdate);
        return "redirect:/turma/main";
    }
}
