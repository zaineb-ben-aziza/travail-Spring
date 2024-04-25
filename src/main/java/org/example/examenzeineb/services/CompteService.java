package org.example.examenzeineb.services;

import lombok.RequiredArgsConstructor;
import org.example.examenzeineb.entities.Compte;
import org.example.examenzeineb.repositories.ICompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor //on utilise required car on a definit l'attribut comme une constate final
public class CompteService implements ICompteService {
    private final ICompteRepository iCompteRepository;
//    @Override
//    public Compte addClient(Compte compte) {
//        return iCompteRepository.save(compte);
//    }



//    @Override
//    public Compte getClient(Long idC) {
//        return iCompteRepository.findById(idC).orElse(null);
//    }
//
//    @Override
//    public List<Compte> getAllClients() {
//        return (List<Compte>) iCompteRepository.findAll();
//    }
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank){ return compte;}

}
