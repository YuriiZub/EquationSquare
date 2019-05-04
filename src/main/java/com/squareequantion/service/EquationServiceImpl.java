package com.squareequantion.service;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.repository.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Crud service implementation
 * Created by Yurii on 5/3/2019.
 */
@Service("equationService")
@Repository
@Transactional
@Lazy
public class EquationServiceImpl implements EquationService {
    @Autowired
    EquationRepository equationRepository;

    @Override
    public EquantionsEntity save(EquantionsEntity equation) {
        return equationRepository.save(equation);
    }
}
