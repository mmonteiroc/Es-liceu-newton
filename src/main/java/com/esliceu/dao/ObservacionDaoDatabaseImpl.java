package com.esliceu.dao;

import com.esliceu.model.Observacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 03/02/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Repository
public class ObservacionDaoDatabaseImpl implements ObservacionDao {
    /*
     * Fabrica que hace sessiones contra la bbdd
     * */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Observacion observacion) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(observacion);
    }
}
