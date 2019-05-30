package com.squareequantion.service.err;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yurii on 5/30/2019.
 *
 * @version 1.0.0
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger logger = Logger.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e) {
        logger.error("Request: " + request.getRequestURL() + " exception " + e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
