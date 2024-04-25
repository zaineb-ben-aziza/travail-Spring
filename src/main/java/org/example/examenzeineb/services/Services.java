package org.example.examenzeineb.services;

import org.example.examenzeineb.entities.Bank;
import org.springframework.stereotype.Service;

@Service
public class Services implements IServices {
    @Override
    public Bank ajouterBank(Bank bank) {
        return bank;
    }
}
