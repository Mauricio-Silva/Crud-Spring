package br.edu.ifms.crudspring.model;

// import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String name;

    // @OneToMany(mappedBy = "turma")
    // List<Teacher> teachers;
}
