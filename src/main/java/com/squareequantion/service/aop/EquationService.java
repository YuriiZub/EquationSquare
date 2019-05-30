package com.squareequantion.service.aop;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.dto.EquationDTO;

/**
 * dao Service
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 */
public interface EquationService {
    void saveSolution(EquantionsEntity equationEntity);
}


