package com.esliceu.dao;

import com.esliceu.model.Satelite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 28/01/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Repository
public class SateliteDaoDatabaseImpl implements SateliteDao {

    /*
     * Fabrica que hace sessiones contra la bbdd
     * */
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Satelite> getAll() {

        Session conexionDatabase = sessionFactory.getCurrentSession();

        CriteriaBuilder criteria = conexionDatabase.getCriteriaBuilder();

        CriteriaQuery<Satelite> criteriaQuery = criteria.createQuery(Satelite.class);

        Root<Satelite> root = criteriaQuery.from(Satelite.class);

        criteriaQuery.select(root);

        Query finalQuery = conexionDatabase.createQuery(criteriaQuery);

        return finalQuery.getResultList();
    }

    @Override
    public Satelite getById(Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Satelite.class, id);
    }

    @Override
    public void insertOrUpdate(Satelite satelite) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(satelite);
    }

    @Override
    public void delete(Satelite satelite) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(satelite);
    }
}