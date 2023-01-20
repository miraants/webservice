package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Rechargement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rechargement;

    @Column(name = "valeur")
    private double valeur;

    @Column(name = "id_utilisateur")
    private int id_utilisateur;

    @Column(name = "statut")
    private int statut;

}
