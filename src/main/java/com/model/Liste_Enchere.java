package com.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Liste_Enchere {

    private String nom_user;
    private String nom_produit;
    private Double prix_min;
    private String nom_categorie;
    private Date daty;
    private int duree;
    private Double commission;
}
