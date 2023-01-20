package com.controller;

import com.TpWsApplication;
import com.connection.ConnectDB;
import com.exception.ResourceNotFoundException;
import com.model.Categorie;
import com.model.Rechargement;


import com.model.Utilisateur;
import com.repository.CategorieRepository;
import com.repository.RechargementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/rechargement")
public class RechargementController {
    @Autowired
    private RechargementRepository rechargementRepository;


    @GetMapping
    public List<Rechargement> getAllRechargement(){
        return rechargementRepository.findAll();
    }

    @PostMapping("/insert")
    public Rechargement createRechargement(@RequestBody Rechargement rechargement){
        return rechargementRepository.save(rechargement);
    }

    @GetMapping("/list")
    public ArrayList<Rechargement> getRechargement() throws SQLException {
        ArrayList<Rechargement> rechargement = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from rechargement";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Rechargement rec = new Rechargement(resultSet.getInt(1), resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4));
                rechargement.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return rechargement;
    }

    @GetMapping("/insert/{valeur}/{id_utilisateur}")
    public Object insertRechargement(@PathVariable int valeur,@PathVariable int id_utilisateur) throws SQLException {
        String sql = "insert into rechargement (valeur,id_utilisateur,statut) values ("+valeur+","+id_utilisateur+",0)";
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;

        Statement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate("commit");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return null;
    }

    @GetMapping("/update/{id_utilisateur}/{somme}")
    public Object updateRechargement(@PathVariable int id_utilisateur,@PathVariable int somme) throws SQLException {
        String sql = "update rechargement set statut=1 where id_utilisateur="+id_utilisateur;
        String sql2="update utilisateur set valeur=(valeur+"+somme+") where id_utilisateur="+id_utilisateur;
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;

        Statement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate("commit");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return null;
    }


}
