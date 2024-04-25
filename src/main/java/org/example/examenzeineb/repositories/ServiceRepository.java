package org.example.examenzeineb.repositories;

import org.example.examenzeineb.entities.Bank;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Bank,Long> {
}
