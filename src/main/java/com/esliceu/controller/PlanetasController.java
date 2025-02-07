package com.esliceu.controller;

import com.esliceu.model.Observacion;
import com.esliceu.model.Planeta;
import com.esliceu.service.ObservacionService;
import com.esliceu.service.PlanetaService;
import com.esliceu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.controller
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Controller
public class PlanetasController {
    @Autowired
    private PlanetaService planetaService;
    @Autowired
    private UserService userService;
    @Autowired
    private ObservacionService observacionService;

    @GetMapping("/planetas")
    @Transactional
    public String getPlanetas(Locale locale, Model model) {

        List<Planeta> planetas = planetaService.getAll();

        model.addAttribute("planetas", planetas);
        return "planetas";
    }


    @PostMapping("/deletePlaneta")
    @Transactional
    public RedirectView deletePlaneta(@RequestParam("idplaneta") Integer idPlaneta) {
        Planeta planeta = planetaService.getById(idPlaneta);


        List<Observacion> observacions = planeta.getObservaciones();
        List<Observacion> copyObservaciones = new LinkedList<>(observacions);

        for (Observacion observacion : copyObservaciones) {
            observacion.getUsuari().getComentariosObservaciones().remove(observacion);
            planeta.getObservaciones().remove(observacion);
            observacionService.delete(observacion);
        }

        planetaService.deletePlaneta(planeta);

        return new RedirectView("planetas");
    }


}
