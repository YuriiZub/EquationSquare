package com.squareequation.service.solution;

import com.squareequation.model.EquationEntity;
import com.squareequation.service.aop.SolutionDone;
import com.squareequation.service.dto.EquationDTO;
import com.squareequation.service.err.DiscriminanteLessThanZeroException;
import com.squareequation.service.err.FirstParamIsZeroException;
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
    public EquationEntity calculateEquation(EquationDTO equationDTO)
            throws FirstParamIsZeroException, DiscriminanteLessThanZeroException {

        verifyFirstEquationParameter(equationDTO);
        double discriminante = verifyDiscriminanteValue(equationDTO);

        EquationEntity resultEntity = new EquationEntity();
        resultEntity.setParamA(equationDTO.getParamA());
        resultEntity.setParamB(equationDTO.getParamB());
        resultEntity.setParamC(equationDTO.getParamC());
        resultEntity.setDiscriminant(discriminante);

        if (discriminante > 0) setTwoEquationResults(resultEntity);
        if (discriminante == 0) setOneEquationResult(resultEntity);

        return resultEntity;
    }

    private void verifyFirstEquationParameter(EquationDTO equationDTO) throws FirstParamIsZeroException {
        if (equationDTO.getParamA() == 0.0) throw new FirstParamIsZeroException();
    }

    private double verifyDiscriminanteValue(EquationDTO equationDTO) throws DiscriminanteLessThanZeroException {
        double discriminante = equationDTO.getParamB() * equationDTO.getParamB() - 4 * equationDTO.getParamA() * equationDTO.getParamC();
        if (discriminante >= 0) return discriminante;
        else throw new DiscriminanteLessThanZeroException(String.valueOf(discriminante));
    }

    /*Equantion has two results x1 and x2, because discriminante > 0*/
    private void setTwoEquationResults(EquationEntity resultEntity) {
        resultEntity.setFirstResult((-resultEntity.getParamB() - Math.sqrt(resultEntity.getDiscriminant())) / (2 * resultEntity.getParamA()));
        resultEntity.setSecondResult((-resultEntity.getParamB() + Math.sqrt(resultEntity.getDiscriminant())) / (2 * resultEntity.getParamA()));
        resultEntity.setSuccessResult(2);
    }

    /*Equantion has one results x1, because discriminante == 0 */
    private void setOneEquationResult(EquationEntity resultEntity) {
        resultEntity.setFirstResult(-resultEntity.getParamB() / (2 * resultEntity.getParamA()));
        resultEntity.setSecondResult(0.0);
        resultEntity.setSuccessResult(1);
    }
}

