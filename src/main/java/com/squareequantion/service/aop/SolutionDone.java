package com.squareequantion.service.aop;

import java.lang.annotation.*;

/**
 * Created by Yurii Zub on 5/25/2019.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface SolutionDone {
}
