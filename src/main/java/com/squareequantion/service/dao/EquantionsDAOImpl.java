package com.squareequantion.service.dao;

import com.squareequantion.model.EquantionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Yurii Zub on 5/12/2019.
 * @version 1.0.1
 */
@Repository
public class EquantionsDAOImpl implements EquantionsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveEquantion(EquantionsEntity equantion) {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(equantion);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
}
