package com.repository;

import com.model.Rechargement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Rechargement, Integer> {
}
