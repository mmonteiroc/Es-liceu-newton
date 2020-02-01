package com.esliceu.service;

import com.esliceu.dao.SateliteDao;
import com.esliceu.model.Satelite;
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
public class SateliteService {

    @Autowired
    private SateliteDao sateliteDao;

    public List<Satelite> getAll() {
        return sateliteDao.getAll();
    }

    public Satelite findById(Integer id) {
        return sateliteDao.getById(id);
    }
}
