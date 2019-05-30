package com.squareequation.service.aop;

import com.squareequation.model.EquationEntity;

/**
 * dao Service
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 */
public interface EquationService {
    void saveSolution(EquationEntity equationEntity);
}


