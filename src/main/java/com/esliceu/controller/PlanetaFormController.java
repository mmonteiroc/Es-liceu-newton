package com.esliceu.controller;

import com.esliceu.model.Planeta;
import com.esliceu.model.Satelite;
import com.esliceu.model.Usuari;
import com.esliceu.model.UsuariPlaneta;
import com.esliceu.service.PlanetaService;
import com.esliceu.service.SateliteService;
import com.esliceu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.controller
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Controller
public class PlanetaFormController {

    @Autowired
    private PlanetaService planetaService;
    @Autowired
    private SateliteService sateliteService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/planetaForm/{idplaneta}")
    @Transactional
    public String modifyPlaneta(@PathVariable("idplaneta") Integer idplaneta, Model model) {
        Integer idUser = (Integer) httpSession.getAttribute("userId");
        Planeta planeta = planetaService.getById(idplaneta);

        model.addAttribute("satelites", sateliteService.getAll());
        model.addAttribute("planeta", planeta);

        UsuariPlaneta usuariPlaneta = null;
        for (UsuariPlaneta toCheck : planeta.getUsuariPlanetas()) {

            if (toCheck.getUsuari().getIdusuari().equals(idUser) && toCheck.getPlanetaUsuariPlanetas().getIdplaneta().equals(idplaneta)) {
                usuariPlaneta = toCheck;
            }
        }
        model.addAttribute("observacion", usuariPlaneta);

        return "planetaForm";
    }

    @GetMapping("/planetaForm")
    @Transactional
    public String addPlaneta(Model model) {
        model.addAttribute("satelites", sateliteService.getAll());
        return "planetaForm";
    }


    @PostMapping("/savePlaneta")
    @Transactional
    public RedirectView savePlaneta(@Nullable @RequestParam("satelites[]") Integer[] idSatelites, @RequestParam("idplaneta") Integer idplaneta, @RequestParam("nom") String nom, @Nullable @RequestParam("habitable") boolean habitable, @RequestParam("massa") Long massa, @Nullable @RequestParam("observacion") String observacion) {


        Planeta planeta = new Planeta();
        if (idplaneta != null) {
            planeta = planetaService.getById(idplaneta);
        }
        planeta.setIdplaneta(idplaneta);
        planeta.setNom(nom);
        planeta.setHabitable(habitable);
        planeta.setMassa(massa);

        if (idSatelites != null) {

            if (idplaneta == null) {
                planeta.setSatelites(new LinkedList<>());
            } else {
                planeta.getSatelites().removeAll(planeta.getSatelites());
            }
            for (Integer id : idSatelites) {
                Satelite satelite = sateliteService.findById(id);
                satelite.setPlaneta(planeta);
                planeta.getSatelites().add(sateliteService.findById(id));
            }
        }


        if ((observacion != null) && (!observacion.equals(""))) {

            Usuari user = userService.findById((Integer) httpSession.getAttribute("userId"));

            if (idplaneta != null) {
                UsuariPlaneta comentarioToLeave = null;
                // Comprovamos primero si hay algun comentario ya escrito entre este usuario y este planeta
                for (UsuariPlaneta usuariPlaneta : planeta.getUsuariPlanetas()) {
                    if (usuariPlaneta.getUsuari().getIdusuari().equals(user.getIdusuari()) && usuariPlaneta.getPlanetaUsuariPlanetas().getIdplaneta().equals(idplaneta)) {
                        comentarioToLeave = usuariPlaneta;
                    }
                }

                if (comentarioToLeave == null) {
                    comentarioToLeave = new UsuariPlaneta();
                    comentarioToLeave.setUsuari(user);
                    comentarioToLeave.setPlanetaUsuariPlanetas(planeta);
                    if (user.getComentariosUsuariPlanetas() == null) {
                        user.setComentariosUsuariPlanetas(new LinkedList<>());
                    }
                    user.getComentariosUsuariPlanetas().add(comentarioToLeave);
                }
                comentarioToLeave.setComentario(observacion);

            } else {
                // Nos ahorramos la comprovacion anteiror ya que significa que es un nuevo planeta y no tendra ningun comentario

                UsuariPlaneta usuariPlaneta = new UsuariPlaneta();
                List<UsuariPlaneta> lista = new LinkedList<>();
                usuariPlaneta.setUsuari(user);
                usuariPlaneta.setPlanetaUsuariPlanetas(planeta);
                usuariPlaneta.setComentario(observacion);
                lista.add(usuariPlaneta);
                planeta.setUsuariPlanetas(lista);
            }
        }


        planetaService.insertOrUpdate(planeta);
        return new RedirectView("/planetas");
    }
}
