package com.squareequantion.dao;

import com.squareequantion.model.EquantionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Created by Yurii on 5/12/2019.
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
