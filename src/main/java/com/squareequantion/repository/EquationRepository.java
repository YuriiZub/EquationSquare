package com.squareequantion.repository;

import com.squareequantion.model.EquantionsEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yurii Zub on 24.03.2019.
 */
public interface EquationRepository extends CrudRepository<EquantionsEntity, Integer> {

}
