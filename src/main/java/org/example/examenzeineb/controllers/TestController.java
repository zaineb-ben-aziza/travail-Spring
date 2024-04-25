package org.example.examenzeineb.controllers;

import lombok.RequiredArgsConstructor;
import org.example.examenzeineb.entities.Bank;
import org.example.examenzeineb.entities.Compte;
import org.example.examenzeineb.repositories.ServiceRepository;
import org.example.examenzeineb.services.CompteService;
import org.example.examenzeineb.services.Services;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class TestController {
    private final Services services;
    private final CompteService compteService;
    @PostMapping("/addBanke")
    public Bank ajouterBank(Bank bank) {
        return services.ajouterBank(bank);

    }
    @PostMapping("/addAccount")
    public Compte ajouterCompteEtAffecterAAgence( Compte compte,  String agenceBank) {
        return compteService.ajouterCompteEtAffecterAAgence(compte, agenceBank);
    }



}
