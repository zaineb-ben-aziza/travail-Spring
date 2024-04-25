package org.example.examenzeineb.Repo;

import org.example.examenzeineb.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByAgence(String agence);
}
