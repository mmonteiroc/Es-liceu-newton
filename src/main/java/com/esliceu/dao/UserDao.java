package com.esliceu.dao;

import com.esliceu.model.Usuari;

import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 28/01/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
public interface UserDao {
    List<Usuari> findAll();

    Usuari findByID(int id);

    Usuari validate(String username, String passwd);

    Usuari findByUsername(String username);

    void persist(Usuari user);
}
