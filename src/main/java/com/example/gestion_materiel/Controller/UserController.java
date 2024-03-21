package com.example.gestion_materiel.Controller;

import com.example.gestion_materiel.Modele.user;
import com.example.gestion_materiel.Reposotery.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adduser")
    public String showUserForm(Model model){
        model.addAttribute("user", new user());
        return "addUserForm";
    }

    @PostMapping("/adduser")
    public String adduser(@Valid @ModelAttribute("user") user user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addUserForm";
        }
        userRepository.save(user);
        return "redirect:/adduser"; // Retourner à la page du formulaire pour afficher le message
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginUser", new user());
        return "loginForm";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginUser") user loginUser, Model model) {
        // Récupérer le nom et l'email du formulaire de connexion
        String nom = loginUser.getNom();
        String email = loginUser.getEmail();

        // Rechercher l'utilisateur dans la base de données en utilisant le nom et l'email
        user existingUser = userRepository.findByNomAndEmail(nom, email);

        // Vérifier si l'utilisateur existe dans la base de données
        if (existingUser == null) {
            // Si l'utilisateur n'existe pas, afficher un message d'erreur
            model.addAttribute("error", "Nom ou email incorrect.");
            return "loginForm"; // Retourner vers la page de connexion avec le message d'erreur
        } else {
            // Si l'utilisateur existe, vous pouvez rediriger vers la page de succès ou faire d'autres traitements
            return "redirect:/materiel/liste";
        }
    }

}
