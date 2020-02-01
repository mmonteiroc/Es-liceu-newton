package com.esliceu.dao;

import com.esliceu.model.Satelite;

import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 28/01/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
public interface SateliteDao {
    List<Satelite> getAll();

    Satelite getById(Integer id);

    void insertOrUpdate(Satelite satelite);

    void delete(Satelite satelite);
}
