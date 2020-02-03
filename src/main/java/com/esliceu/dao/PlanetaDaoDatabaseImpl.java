package com.esliceu.dao;

import com.esliceu.model.Planeta;
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
 * Date: 27/01/2020
 * Package: com.esliceu.dao
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */
@Repository
public class PlanetaDaoDatabaseImpl implements PlanetaDao {

    /*
     * Fabrica que hace sessiones contra la bbdd
     * */
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Planeta findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Planeta.class, id);
    }

    @Override
    public List<Planeta> findAll() {




        /*
         * Iniciamos la sessión (La cogemos de la hibernate config que creamoszx)
         * */
        Session conexionDatabase = sessionFactory.getCurrentSession();



        /*
         * MANERA SIN CRITERIA
         *
         * conexionDatabase.createQuery("from com.esliceu.model.Planeta");
         *
         * */


        /*
         * Nos permite hacer consultas con el objeto criteria
         * */
        CriteriaBuilder criteria = conexionDatabase.getCriteriaBuilder();

        /*
         * Creamos una query y le pasamos por parametro cual sera los datos que retorna la query
         * */
        CriteriaQuery<Planeta> criteriaQuery = criteria.createQuery(Planeta.class);

        /*
         * Objeto Root que nos defime cual es la tabla sobre las que se hace las querys
         * */
        Root<Planeta> root = criteriaQuery.from(Planeta.class);

        /*
         *
         * */
        criteriaQuery.select(root);

        /*
         * Aqui definimos el statement
         * */
        Query finalQuery = conexionDatabase.createQuery(criteriaQuery);

        /*
         * Nos retorna la lista
         * */
        return finalQuery.getResultList();
    }

    @Override
    public void insertOrUpdate(Planeta planeta) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(planeta);

    }

    @Override
    public void persist(Planeta planeta) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(planeta);
    }

    @Override
    public void delete(Planeta planeta) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(planeta);
    }
}
