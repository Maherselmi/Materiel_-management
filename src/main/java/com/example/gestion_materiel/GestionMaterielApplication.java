package com.example.gestion_materiel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.example.gestion_materiel"})
public class GestionMaterielApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionMaterielApplication.class, args);
    }

}
