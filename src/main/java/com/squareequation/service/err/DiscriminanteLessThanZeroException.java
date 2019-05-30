package com.squareequation.service.err;

/**
 * Created by Yurii on 5/30/2019.
 *
 * @version 1.0.0
 */
public class DiscriminanteLessThanZeroException extends RuntimeException {
    public DiscriminanteLessThanZeroException(String message) {
        super("Discriminante is less than zero! D = " + message);
    }
}
