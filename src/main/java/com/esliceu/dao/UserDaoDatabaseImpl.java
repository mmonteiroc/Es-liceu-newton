package com.esliceu.dao;

import com.esliceu.model.Usuari;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
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
public class UserDaoDatabaseImpl implements UserDao {
    /*
     * Fabrica que hace sessiones contra la bbdd
     * */
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Usuari> findAll() {
        Session conexionDatabase = sessionFactory.getCurrentSession();

        CriteriaBuilder criteria = conexionDatabase.getCriteriaBuilder();

        CriteriaQuery<Usuari> criteriaQuery = criteria.createQuery(Usuari.class);

        Root<Usuari> root = criteriaQuery.from(Usuari.class);

        criteriaQuery.select(root);

        Query finalQuery = conexionDatabase.createQuery(criteriaQuery);

        return finalQuery.getResultList();
    }

    @Override
    public Usuari findByID(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Usuari.class, id);
    }

    @Override
    public Usuari validate(String username, String passwd) {

        Criteria criteria = sessionFactory
                .getCurrentSession().createCriteria(Usuari.class);
        criteria.add(Expression.eq("username", username));
        criteria.add(Expression.eq("password", passwd));

        return (Usuari) criteria.uniqueResult();
    }

    @Override
    public Usuari findByUsername(String username) {
        Criteria criteria = sessionFactory
                .getCurrentSession().createCriteria(Usuari.class);
        criteria.add(Expression.eq("username", username));

        return (Usuari) criteria.uniqueResult();
    }

    @Override
    public void persist(Usuari user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(user);
    }
}
