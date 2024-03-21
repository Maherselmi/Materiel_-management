package com.example.gestion_materiel.Reposotery;

import com.example.gestion_materiel.Modele.materiel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielRepository extends JpaRepository<materiel,Integer> {

}
