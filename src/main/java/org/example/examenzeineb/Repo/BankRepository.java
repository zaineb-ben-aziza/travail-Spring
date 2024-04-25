package com.example.examanhoussemhosni.Repo;

import com.example.examanhoussemhosni.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByAgence(String agence);
}
