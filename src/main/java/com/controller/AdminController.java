package com.controller;

import com.exception.ResourceNotFoundException;
import com.model.Rechargement;


import com.model.Utilisateur;
import com.repository.AdminRepository;
import com.repository.RechargementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private RechargementRepository rechargementRepository;
    private AdminRepository admin;

    /*@PutMapping("{id}")
    public ResponseEntity<Rechargement> updateRecharge(@PathVariable Integer id){
        Rechargement updateRechargement= rechargementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));

        updateRechargement.setStatut(1);

        rechargementRepository.save(updateRechargement);
        return ResponseEntity.ok(updateRechargement);

    }
    @PutMapping("{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable long id,int a){
        Utilisateur updateUtilisateur= utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));
        Rechargement updateRechargement= rechargementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rechargement not exist with id: " + id));

        updateUtilisateur.setValeur(updateUtilisateur.getValeur()+updateRechargement.getValeur());

        utilisateurRepository.save(updateUtilisateur);
        return ResponseEntity.ok(updateUtilisateur);
    }*/


}
