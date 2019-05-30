package com.squareequantion.service.solution;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.aop.SolutionDone;
import com.squareequantion.service.dto.EquationDTO;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Solution for solving of square equantion
 * Enable AutoProxy in MyConfig
 *
 * @author Yurii Zub
 * @version 1.2.3
 */

@Service("equationSolution")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EquationSolutionImpl implements EquationSolution {

    public EquationSolutionImpl() {

    }

    @SolutionDone
    public EquantionsEntity calculateEquation(EquationDTO equationDTO) throws Exception {

        verifyFirstEquationParameter(equationDTO);
        double discriminante = verifyDiscriminanteValue(equationDTO);

        EquantionsEntity resultEntity = new EquantionsEntity();
        resultEntity.setParamA(equationDTO.getParamA());
        resultEntity.setParamB(equationDTO.getParamB());
        resultEntity.setParamC(equationDTO.getParamC());
        resultEntity.setDiscriminant(discriminante);

        if (discriminante > 0) setTwoEquationResults(resultEntity);
        if (discriminante == 0) setOneEquationResult(resultEntity);

        return resultEntity;
    }

    private void verifyFirstEquationParameter(EquationDTO equationDTO) throws Exception {
        if (equationDTO.getParamA() == 0.0) throw new Exception("First param couldn't be zero");
    }

    private double verifyDiscriminanteValue(EquationDTO equationDTO) throws Exception {
        double discriminante = equationDTO.getParamB() * equationDTO.getParamB() - 4 * equationDTO.getParamA() * equationDTO.getParamC();
        if (discriminante >= 0) return discriminante;
        else throw new Exception("Equation coulnd't be solved, because D < 0;");
    }

    /*Equantion has two results x1 and x2, because discriminante > 0*/
    private void setTwoEquationResults(EquantionsEntity resultEntity) {
        resultEntity.setFirstResult((-resultEntity.getParamB() - Math.sqrt(resultEntity.getDiscriminant())) / (2 * resultEntity.getParamA()));
        resultEntity.setSecondResult((-resultEntity.getParamB() + Math.sqrt(resultEntity.getDiscriminant())) / (2 * resultEntity.getParamA()));
        resultEntity.setSuccessResult(2);
    }

    /*Equantion has one results x1, because discriminante == 0 */
    private void setOneEquationResult(EquantionsEntity resultEntity) {
        resultEntity.setFirstResult(-resultEntity.getParamB() / (2 * resultEntity.getParamA()));
        resultEntity.setSecondResult(0.0);
        resultEntity.setSuccessResult(1);
    }
}

