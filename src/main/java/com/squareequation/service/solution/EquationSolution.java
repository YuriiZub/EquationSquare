package com.squareequation.service.solution;

import com.squareequation.model.EquationEntity;
import com.squareequation.service.dto.EquationDTO;
import com.squareequation.service.err.DiscriminanteLessThanZeroException;
import com.squareequation.service.err.FirstParamIsZeroException;

/**
 * Interface for calculation of result
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 */

public interface EquationSolution  {
    EquationEntity calculateEquation(EquationDTO equationDTO)
            throws FirstParamIsZeroException, DiscriminanteLessThanZeroException;
}

