package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Produit {
    private int id_produit;
    private String nom_produit;
    private int id_categorie;
    private Double prix_min;

}
