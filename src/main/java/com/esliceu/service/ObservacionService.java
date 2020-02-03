package com.esliceu.service;

import com.esliceu.dao.ObservacionDao;
import com.esliceu.model.Observacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 03/02/2020
 * Package: com.esliceu.service
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Service
public class ObservacionService {

    @Autowired
    private ObservacionDao observacionDao;

    public void delete(Observacion observacion) {
        observacionDao.delete(observacion);
    }
}
