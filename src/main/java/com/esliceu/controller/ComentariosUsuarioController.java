package com.esliceu.controller;

import com.esliceu.model.Observacion;
import com.esliceu.model.Planeta;
import com.esliceu.model.Usuari;
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

import javax.servlet.http.HttpSession;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 29/01/2020
 * Package: com.esliceu.controller
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Controller
public class ComentariosUsuarioController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserService userService;
    @Autowired
    private PlanetaService planetaService;
    @Autowired
    private ObservacionService observacionService;


    @GetMapping("/planetas/comentarios")
    @Transactional
    public String seeAllPlanetasComented(Model model) {

        Usuari user = userService.findById((Integer) httpSession.getAttribute("userId"));

        model.addAttribute("usuario", user);
        model.addAttribute("Comentarios", user.getComentariosObservaciones());

        return "comentariosUsuario";
    }

    @PostMapping("/comentarios/delete")
    @Transactional
    public RedirectView deleteComment(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("idPlaneta") Integer idPlaneta, @RequestParam("comentario") String comentario) {
        Planeta planeta = planetaService.getById(idPlaneta);
        Usuari user = userService.findById(idUsuario);

        Observacion toDelete = null;

        for (Observacion checkToDelete : planeta.getObservaciones()) {
            if (checkToDelete.getComentario().equalsIgnoreCase(comentario) && checkToDelete.getUsuari().getIdusuari().equals(idUsuario) && checkToDelete.getPlanetaUsuariPlanetas().getIdplaneta().equals(idPlaneta)) {

                System.out.println("#############################");
                System.out.println("Relacion intermedia encontrada: " + checkToDelete.toString());
                toDelete = checkToDelete;
            }
        }

        planeta.getObservaciones().remove(toDelete);
        user.getComentariosObservaciones().remove(toDelete);

        planetaService.persist(planeta);
        userService.persist(user);
        observacionService.delete(toDelete);

        return new RedirectView("../planetas/comentarios");
    }

}
