package com.esliceu.controller;

import com.esliceu.model.Planeta;
import com.esliceu.model.Usuari;
import com.esliceu.model.UsuariPlaneta;
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


    @GetMapping("/planetas/comentarios")
    @Transactional
    public String seeAllPlanetasComented(Model model) {

        Usuari user = userService.findById((Integer) httpSession.getAttribute("userId"));

        model.addAttribute("usuario", user);
        model.addAttribute("Comentarios", user.getComentariosUsuariPlanetas());

        return "comentariosUsuario";
    }

    @PostMapping("/comentarios/delete")
    @Transactional
    public RedirectView deleteComment(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("idPlaneta") Integer idPlaneta, @RequestParam("comentario") String comentario) {
        Planeta planeta = planetaService.getById(idPlaneta);
        Usuari user = userService.findById(idUsuario);

        UsuariPlaneta toDelete = null;

        for (UsuariPlaneta checkToDelete : planeta.getUsuariPlanetas()) {
            if (checkToDelete.getComentario().equalsIgnoreCase(comentario) && checkToDelete.getUsuari().getIdusuari().equals(idUsuario) && checkToDelete.getPlanetaUsuariPlanetas().getIdplaneta().equals(idPlaneta)) {

                System.out.println("#############################");
                System.out.println("Relacion intermedia encontrada: " + checkToDelete.toString());
                toDelete = checkToDelete;
            }
        }

        planeta.getUsuariPlanetas().remove(toDelete);
        planetaService.insertOrUpdate(planeta);
        return new RedirectView("/planetas/comentarios");
    }

}
