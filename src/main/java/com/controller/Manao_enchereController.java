package com.controller;

import com.TpWsApplication;
import com.connection.ConnectDB;
import com.exception.Manao_enchereNotFoundException;
import com.exception.ResourceNotFoundException;
import com.model.Categorie;
import com.model.Manao_enchere;
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
@RequestMapping("/api/v1/manao_enchere")
public class Manao_enchereController {

    @GetMapping("/list")
    public ArrayList<Manao_enchere> getManao_enchere() throws SQLException {
        ArrayList<Manao_enchere> manao_enchere = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from Manao_enchere";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Manao_enchere rec = new Manao_enchere(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4), resultSet.getDate(5),resultSet.getInt(6),resultSet.getDouble(7));
                manao_enchere.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return manao_enchere;
    }

    @GetMapping("/insert/{sql}")
    public Object insertEnchere(@PathVariable String sql) throws SQLException {
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



}
