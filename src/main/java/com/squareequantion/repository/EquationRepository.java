package com.squareequantion.repository;

import com.squareequantion.model.EquantionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository
 * Created by Yurii Zub on 24.03.2019.
 *
 * @interface
 */
public interface EquationRepository extends CrudRepository<EquantionsEntity, Integer> {

}
