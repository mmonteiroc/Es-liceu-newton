package com.esliceu.service;

import com.esliceu.dao.PlanetaDao;
import com.esliceu.model.Planeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu.service
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Service
public class PlanetaService {
    @Autowired
    PlanetaDao planetaDao;

    public List<Planeta> getAll() {
        return planetaDao.findAll();
    }

    public void deletePlaneta(Planeta planeta) {

        planetaDao.delete(planeta);
    }

    public Planeta getById(Integer idplaneta) {
        return planetaDao.findById(idplaneta);
    }

    public void insertOrUpdate(Planeta planeta) {
        planetaDao.insertOrUpdate(planeta);
    }


    public void persist(Planeta planeta) {
        planetaDao.persist(planeta);
    }
}
