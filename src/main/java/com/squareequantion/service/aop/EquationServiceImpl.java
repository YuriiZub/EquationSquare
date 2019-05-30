package com.squareequantion.service.aop;

import com.squareequantion.service.dao.EquantionsDAO;
import com.squareequantion.model.EquantionsEntity;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Class for saving equation result to DB
 * Enable AutoProxy in MyConfig
 *
 * @author Created by Yurii Zub on 5/3/2019.
 * @version 1.2.0
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
            returning = "equationEntity")
    public void saveSolution(EquantionsEntity equationEntity) {
        equantionsDAO.saveEquantion(equationEntity);
    }
}
