package com.squareequantion.service.solution;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.dto.EquationDTO;
import com.squareequantion.service.err.DiscriminanteLessThanZeroException;
import com.squareequantion.service.err.FirstParamIsZeroException;

/**
 * Interface for calculation of result
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 */

public interface EquationSolution  {
    EquantionsEntity calculateEquation(EquationDTO equationDTO)
            throws FirstParamIsZeroException, DiscriminanteLessThanZeroException;
}

