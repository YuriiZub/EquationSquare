package com.squareequantion.service;

import com.squareequantion.model.EquantionsEntity;

/**
 * Interface for calculation of result
 * Created by Yurii on 5/3/2019.
 *
 * @interface
 */
public interface EquationSolution {
    void setResult(EquantionsEntity result);

    void doSolution();
}

