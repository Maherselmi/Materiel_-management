package com.example.gestion_materiel;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        // Gérer l'erreur et afficher une page d'erreur personnalisée
        return "errorPage"; // Remplacez "errorPage" par le nom de votre page d'erreur personnalisée
    }

    public String getErrorPath() {
        return "/error";
    }
}
