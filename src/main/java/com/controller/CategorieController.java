package com.controller;

import com.TpWsApplication;
import com.connection.ConnectDB;
import com.exception.CategorieNotFoundException;
import com.model.Categorie;
import com.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/api/v1/categorie")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/list")
    public ArrayList<Categorie> getCategorie() throws SQLException {
        ArrayList<Categorie> categorie = new ArrayList<>();
        ConnectDB postgreSQL = TpWsApplication.getPostgreSQL();
        Connection conn = null;
        PreparedStatement stmt=null;
        try {
            conn = postgreSQL.getConnection();
            String sql = "select * from categorie";
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                Categorie cat = new Categorie(resultSet.getInt(1), resultSet.getString(2));
                categorie.add(cat);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (stmt!=null) stmt.close();
        }
        return categorie;
    }

    @GetMapping("/insert/{nom}")
    public Object insertCategorie(@PathVariable String nom) throws SQLException {
        String sql = "insert into categorie  values (default,'"+nom+"')";
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

    @GetMapping("{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id){
        Categorie r=categorieRepository.findById(id).orElseThrow(() -> new CategorieNotFoundException(("Categorie not exist with id :" + id)));
        return ResponseEntity.ok(r);
    }

}
