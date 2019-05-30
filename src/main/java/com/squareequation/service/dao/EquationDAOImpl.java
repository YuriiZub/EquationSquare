package com.squareequation.service.dao;

import com.squareequation.model.EquationEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Yurii Zub on 5/12/2019.
 * @version 1.0.1
 */
@Repository
public class EquationDAOImpl implements EquationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveEquantion(EquationEntity equantion) {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(equantion);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
}
