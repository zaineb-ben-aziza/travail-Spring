package org.example.examenzeineb.controllers;

import lombok.RequiredArgsConstructor;
import org.example.examenzeineb.entities.Compte;
import org.example.examenzeineb.services.ICompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientRestController {
    private final ICompteService iCompteService;
//    //on a cree 3 services donc on va les exposer ici
//    @PostMapping("/addClient")
//    public Compte addClient(@RequestBody Compte compte){
//        return iCompteService.addClient(compte);
//
//    }
//    @GetMapping("/getClient/{idC}")
//    public Compte getClient(@PathVariable Long idC){
//        return iCompteService.getClient(idC);
//
//    }
//    public List<Compte> getAllClients(){
//        return iCompteService.getAllClients();
//    }

}
