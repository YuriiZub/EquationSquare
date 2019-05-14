package com.squareequantion.controller;

import com.squareequantion.service.EquationService;
import com.squareequantion.service.EquationSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.squareequantion.model.EquantionsEntity;

import javax.servlet.http.HttpServletRequest;


/**
 * Main controller of Equation application
 *
 * @author Yurii Zub
 * @version 1.2.0
 */
@Controller
public class EquantionController {

    @Autowired
    EquationService service;

    @Autowired
    EquationSolution solution;

    /**
     * Getting of my page
     *
     * @param model model
     * @return return's of main page
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMainPage(Model model, HttpServletRequest request) {
        return "index";
    }

    /**
     * Submit data for calculation
     *
     * @param equantion source data
     * @param model     model
     * @return return's of results
     */

    @Transactional
    @RequestMapping(value = "/equation", method = RequestMethod.POST)
    public String calcSubmit(@ModelAttribute EquantionsEntity equantion, Model model) {
        model.addAttribute("saved", "Some problems!");
        solution.setResult(equantion);
        solution.doSolution();
        service.save(equantion);
        model.addAttribute("saved", "All saved");
        model.addAttribute("equation", equantion);
        return "results";
    }

    /**
     * Page for showing calculated data
     *
     * @param model model
     * @return return's page with calculation
     */
    @RequestMapping(value = "/equation", method = RequestMethod.GET)
    public String calcForm(Model model, HttpServletRequest request) {
        String pagename = request.getRequestURL().toString();
        model.addAttribute("pagename", pagename);
        model.addAttribute("saved", "");
        model.addAttribute("equantion", new EquantionsEntity());
        return "equantion";
    }
}
