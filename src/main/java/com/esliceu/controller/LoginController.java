package com.esliceu.controller;

import com.esliceu.model.Usuari;
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
 * Date: 28/01/2020
 * Package: com.esliceu.controller
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String getLogin() {

        return "login";
    }

    @PostMapping("/login")
    @Transactional
    public RedirectView validateLogin(@RequestParam("username") String username, @RequestParam("passwd") String passwd, Model model) {
        RedirectView redirectView;

        if (userService.validateUser(username, passwd)) {

            Usuari user = userService.finByUsername(username);
            httpSession.setAttribute("authed", true);
            httpSession.setAttribute("userId", user.getIdusuari());
            httpSession.setAttribute("username", user.getNom() + " " + user.getCognoms());
            httpSession.setMaxInactiveInterval(60 * 5); // 5 mins

            redirectView = new RedirectView("planetas");
        } else {

            model.addAttribute("errorValidation", true);
            redirectView = new RedirectView("login");
        }

        return redirectView;
    }
}
