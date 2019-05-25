package com.squareequantion.service.solution;

import com.squareequantion.service.dto.EquationDTO;

/**
 * Interface for calculation of result
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @interface
 * @return EquationDTO
 */

public interface EquationSolution {
    EquationDTO doSolution(EquationDTO equationDTO);
}

