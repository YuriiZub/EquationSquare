package com.squareequantion.service.err;

import com.squareequantion.service.dto.EquationDTO;

/**
 * Created by Yurii on 5/30/2019.
 *
 * @version 1.0.0
 */
public class FirstParamIsZeroException extends RuntimeException {
    public FirstParamIsZeroException() {
        super("First parameter coudln't be zero!");
    }
}
