package br.edu.ifms.crudspring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Teacher;
// import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    TurmaService turmaService;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public Teacher getTeacherById(UUID id) {
        return teacherRepository.getById(id);
    }


    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        // Turma turmaOfTeacher = turmaService.getTurmaById(id);
        // teacher.setTurma(turmaOfTeacher);
        // teacherRepository.save(teacher);
        // List<Teacher> teachersList = turmaOfTeacher.getTeachers();
        // teachersList.add(teacher);
        // turmaService.saveTurma(turmaOfTeacher);
        // Teacher teacher = new Teacher(id, name, email, password, turma);
        // teacherRepository.save(teacher);
        // List<Teacher> teachersList = turma.getTeachers();
        // teachersList.add(teacher);
        // turmaService.saveTurma(turma);
    }


    public void deleteTeacherById(UUID id) {
        teacherRepository.deleteById(id);
    }
}
