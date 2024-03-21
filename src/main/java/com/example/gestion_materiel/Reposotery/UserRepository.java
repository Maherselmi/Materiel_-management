package com.example.gestion_materiel.Reposotery;

import com.example.gestion_materiel.Modele.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user,Integer> {
    user findByNomAndEmail(String nom, String email);

}
