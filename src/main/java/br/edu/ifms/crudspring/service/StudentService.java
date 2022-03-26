package br.edu.ifms.crudspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.repository.StudentReposiroty;

@Service
public class StudentService {

    @Autowired
    StudentReposiroty studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
