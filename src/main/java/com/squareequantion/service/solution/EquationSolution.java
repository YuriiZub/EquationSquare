package com.squareequantion.service.solution;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.dto.EquationDTO;

/**
 * Interface for calculation of result
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 * @return EquationDTO
 */

public interface EquationSolution  {
    EquantionsEntity calculateEquation(EquationDTO equationDTO) throws Exception;
}

