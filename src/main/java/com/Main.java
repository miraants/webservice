package com;


import com.model.Utilisateur;

import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Date;


@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {SpringApplication.run(Main.class, args);}
    @Autowired
    AdminRepository adm;
        @Override
        public void run(String... args) throws Exception {

        }


}
