package com.esliceu.dao;

import com.esliceu.model.Planeta;

import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
public interface PlanetaDao {
    public Planeta findById(int id);

    public List<Planeta> findAll();

    public void insertOrUpdate(Planeta planeta);

    public void delete(Planeta id);

    public void persist(Planeta planeta);


}
