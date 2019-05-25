package com.squareequantion.service.aop;

import com.squareequantion.service.dao.EquantionsDAO;
import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.dto.EquationDTO;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Class for saving equation result to DB
 * Enable AutoProxy in MyConfig
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @version 1.1.0
 */

@Aspect
@Service("equationService")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EquationServiceImpl implements EquationService {

    @Autowired
    EquantionsDAO equantionsDAO;

    @Override
    @AfterReturning(
            pointcut = "@annotation(SolutionDone)",
            returning = "equationDTO")
    public void saveSolution(EquationDTO equationDTO) {
        EquantionsEntity entity = new EquantionsEntity();
        entity.setParamA(equationDTO.getParamA());
        entity.setParamB(equationDTO.getParamB());
        entity.setParamC(equationDTO.getParamC());
        entity.setDiscriminant(equationDTO.getDiscriminant());
        entity.setFirstResult(equationDTO.getFirstResult());
        entity.setSecondResult(equationDTO.getSecondResult());
        entity.setSuccessResult(equationDTO.getSuccessResult());
        equantionsDAO.saveEquantion(entity);
    }
}
