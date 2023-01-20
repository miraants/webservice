package com.controller;

import com.TpWsApplication;
import com.connection.ConnectDB;
import com.exception.Manao_enchereNotFoundException;
import com.exception.ResourceNotFoundException;
import com.model.*;


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
@RequestMapping("/api/v1/liste_enchere")
public class ListeEnchereController {

    @GetMapping
    public ArrayList<Liste_Enchere> getManao_enchere() throws SQLException {
        ArrayList<Liste_Enchere> liste_enchere = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from v_liste_enchere";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Liste_Enchere rec = new Liste_Enchere(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4), resultSet.getDate(5),resultSet.getInt(6),resultSet.getDouble(7));
                liste_enchere.add(rec);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return liste_enchere;
    }




}
