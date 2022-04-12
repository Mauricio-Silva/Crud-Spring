package br.edu.ifms.crudspring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.repository.TurmaRepository;

@Service
public class TurmaService {
    
    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma getTurmaById(UUID id) {
        return turmaRepository.getById(id);
    }
    
    public void saveTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    public void deleteTurmaById(UUID id) {
        turmaRepository.deleteById(id);
    }
}
