package com.squareequantion.service;

import com.squareequantion.dao.EquantionsDAO;
import com.squareequantion.model.EquantionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DAO service implementation
 * @author  Created by Yurii on 5/3/2019.
 * @version 1.0.2
 */

@Service
public class EquationServiceImpl implements EquationService {

    @Autowired
    EquantionsDAO equantionsDAO;

    @Override
    public void save(EquantionsEntity equation) {
        equantionsDAO.saveEquantion(equation);
    }
}
