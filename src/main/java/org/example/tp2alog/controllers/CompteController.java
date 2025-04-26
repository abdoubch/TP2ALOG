package org.example.tp2alog.controllers;




import lombok.RequiredArgsConstructor;
import org.example.tp2alog.models.Compte;
import org.example.tp2alog.models.Operation;
import org.example.tp2alog.services.CompteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping("/test")
    public String test() {
        return "Test endpoint works!";
    }

    @GetMapping("/GestionComptes")
    public String recupererPage(Model model) {
        // Initialize empty values for first load
        model.addAttribute("numero", "");
        model.addAttribute("date", "");
        model.addAttribute("solde", "");
        model.addAttribute("operations", Collections.emptyList());

        return "compte";
    }

    @PostMapping("/GestionComptes")
    public String recupererInfosCompte(@RequestParam("code") String numero, Model model) {
        Optional<Compte> compteOpt = compteService.getCompteByNumero(numero);

        if (compteOpt.isPresent()) {
            Compte compte = compteOpt.get();
            List<Operation> operations = compteService.getOperationsByCompte(compte);

            model.addAttribute("numero", compte.getNumero());
            model.addAttribute("date", compte.getDateCreation());
            model.addAttribute("solde", compte.getSolde());
            model.addAttribute("operations", operations);
        } else {
            model.addAttribute("numero", numero);
            model.addAttribute("date", "Compte non trouvé");
            model.addAttribute("solde", "");
            model.addAttribute("operations", Collections.emptyList());
        }

        return "compte";
    }
}
