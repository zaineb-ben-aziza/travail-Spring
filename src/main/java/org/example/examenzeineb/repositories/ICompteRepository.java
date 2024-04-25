package org.example.examenzeineb.repositories;

import org.example.examenzeineb.entities.Compte;
import org.springframework.data.repository.CrudRepository;

public interface ICompteRepository extends CrudRepository<Compte,Long> {
}
