package com.example.gestion_materiel.Controller;

import com.example.gestion_materiel.Modele.materiel;
import com.example.gestion_materiel.Reposotery.MaterielRepository;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.Document;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    @GetMapping("/pdf")
    public void genererPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=liste_materiel.pdf");

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument = new PdfDocument(writer);

        Document document = new Document(pdfDocument);

        Table table = new Table(new float[]{4, 3, 3});
        table.addHeaderCell("Nom");
        table.addHeaderCell("Catégorie");
        table.addHeaderCell("Quantité");

        List<materiel> listeMateriel = materielRepository.findAll();
        for (materiel mat : listeMateriel) {
            table.addCell(mat.getNom());
            table.addCell(mat.getCategorie());
            table.addCell(String.valueOf(mat.getQuantite()));
        }


        document.add(table);

        document.close();


        response.getOutputStream().flush();
    }
    @GetMapping("/rechercher")
    public String rechercherParId(@RequestParam("id") int id, Model model) {
        Optional<materiel> materielOptional = materielRepository.findById(id);
        if (materielOptional.isPresent()) {
            List<materiel> listeMateriel = new ArrayList<>();
            listeMateriel.add(materielOptional.get());
            model.addAttribute("listeMateriel", listeMateriel);
        } else {

            model.addAttribute("listeMateriel", Collections.emptyList());
        }
        return "listeMateriel";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("materiel", new materiel());
        return "addMateriel";
    }

    @PostMapping("/ajouter")
    public String ajouterMateriel(@ModelAttribute("materiel") materiel materiel) {
        materielRepository.save(materiel);
        return "redirect:/materiel/liste";
    }




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
            materielRepository.save(materiel);
            return "redirect:/materiel/liste";
        }
    @GetMapping("/supprimer/{id}")
    public String supprimerMateriel(@PathVariable("id") int id) {
        materielRepository.deleteById(id);
        return "redirect:/materiel/liste";
    }
    }







