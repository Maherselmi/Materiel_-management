package com.example.gestion_materiel.Controller;

import com.example.gestion_materiel.Modele.materiel;
import com.example.gestion_materiel.Reposotery.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/materiel")
public class MaterielController {

    @Autowired
    private MaterielRepository materielRepository;

    @GetMapping("/liste")
    public String afficheMateriel(Model model) {
        List<materiel> listeMateriel = materielRepository.findAll();
        model.addAttribute("listeMateriel", listeMateriel);
        return "listeMateriel";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("materiel", new materiel());
        return "addMateriel";
    }

    @PostMapping("/ajouter")
    public String ajouterMateriel(@ModelAttribute("materiel") materiel materiel) {
        // Sauvegarder le nouveau matériel dans la base de données
        materielRepository.save(materiel);
        // Rediriger vers la page de la liste de matériel après l'ajout réussi
        return "redirect:/materiel/liste";
    }



        // Autres méthodes du contrôleur...

        @GetMapping("/modifier/{id}")
        public String afficherFormulaireModification(@PathVariable("id") int id, Model model) {
            Optional<materiel> materielOptional = materielRepository.findById(id);
            if (materielOptional.isPresent()) {
                materiel materiel = materielOptional.get();
                model.addAttribute("materiel", materiel);
                return "modifierMateriel";
            } else {
                // Gérer le cas où le matériel avec l'ID spécifié n'est pas trouvé
                return "redirect:/materiel/liste";
            }
        }

        @PostMapping("/modifier")
        public String modifierMateriel(@ModelAttribute("materiel") materiel materiel) {
            // Mettre à jour le matériel dans la base de données
            materielRepository.save(materiel);
            // Rediriger vers la page de liste de matériel après la modification réussie
            return "redirect:/materiel/liste";
        }
    @GetMapping("/supprimer/{id}")
    public String supprimerMateriel(@PathVariable("id") int id) {
        materielRepository.deleteById(id);
        return "redirect:/materiel/liste";
    }
    }







