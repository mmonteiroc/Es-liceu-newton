package com.esliceu.controller;

import com.esliceu.model.Satelite;
import com.esliceu.service.SateliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 03/02/2020
 * Package: com.esliceu.controller
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Controller
public class SateliteFormController {
    @Autowired
    private SateliteService sateliteService;


    @GetMapping("/addSatelite")
    @Transactional
    public String addPlaneta(Model model) {
        return "sateliteForm";
    }

    @PostMapping("/addSatelite")
    @Transactional
    public RedirectView savePlaneta(@RequestParam("nom") String nom, @RequestParam("massa") Long massa, @RequestParam("velocitat") Integer velocitat) {

        Satelite satelite = new Satelite();
        satelite.setMassa(massa);
        satelite.setVelocitat(velocitat);
        satelite.setNom(nom);

        sateliteService.insertOrUpdate(satelite);
        return new RedirectView("planetas");
    }

}
