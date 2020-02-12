package com.esliceu.service;

import com.esliceu.dao.UserDao;
import com.esliceu.model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 28/01/2020
 * Package: com.esliceu.service
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public List<Usuari> findAll() {
        return userDao.findAll();
    }

    public Usuari findById(Integer id) {
        return userDao.findByID(id);
    }

    public boolean validateUser(String username, String passwd) {

        Usuari user = userDao.validate(username, passwd);
        return user != null;
    }

    public Usuari finByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void persist(Usuari user) {
        userDao.persist(user);
    }
}
