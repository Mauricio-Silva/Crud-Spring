package br.edu.ifms.crudspring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(UUID id) {
        return studentRepository.getById(id);
    }


    public void saveStudent(Student student) {
        studentRepository.save(student);
    }


    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
    }
}
