package com.squareequantion.service.solution;

import com.squareequantion.service.aop.SolutionDone;
import com.squareequantion.service.dto.EquationDTO;
import com.squareequantion.service.solution.EquationSolution;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Solution for solving of square equantion
 * Enable AutoProxy in MyConfig
 * @author Yurii Zub
 * @version 1.1.3
 */

@Service("equationSolution")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class EquationSolutionImpl implements EquationSolution {

    public EquationSolutionImpl() {

    }

    /**
     * Method for calculation
     * @param equationDTO
     * @return
     */
    @SolutionDone
    public EquationDTO doSolution(EquationDTO equationDTO) {
        /*calculation of descriminante*/
        double a = equationDTO.getParamA();
        double b = equationDTO.getParamB();
        double c = equationDTO.getParamC();
        double discriminant;
        double D, x1, x2 = 0.0;
        int successResult = 0;

        if (a != 0) {
            D = b * b - 4 * a * c;
        /*Equantion has two results x1 and x2*/
            if (D > 0) {
                x1 = (-b - Math.sqrt(D)) / (2 * a);
                x2 = (-b + Math.sqrt(D)) / (2 * a);
                successResult = 2;
            }
        /*Equantion has one results x1 */
            else if (D == 0) {
                x1 = -b / (2 * a);
                x2 = 0.0;
                successResult = 1;
            }
        /*Equantion has not any results*/
            else {
                x1 = 0.0;
                x2 = 0.0;
                successResult = 0;
            }
        }
        /*First parameter is zero value*/
        else {
            D = 0;
            x1 = 0;
            x2 = 0;
            successResult = -1;
        }
        equationDTO.setDiscriminant(D);
        equationDTO.setFirstResult(x1);
        equationDTO.setSecondResult(x2);
        equationDTO.setSuccessResult(successResult);
        return equationDTO;
    }

}
