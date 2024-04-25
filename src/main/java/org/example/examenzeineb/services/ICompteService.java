package org.example.examenzeineb.services;

import org.example.examenzeineb.entities.Compte;

import java.util.List;

public interface ICompteService {

//    Compte addClient(Compte compte);
//    Compte getClient(Long idC);
//    List<Compte> getAllClients();
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);

}
