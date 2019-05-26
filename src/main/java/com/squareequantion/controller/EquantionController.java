package com.squareequantion.controller;

import com.squareequantion.service.solution.EquationSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.squareequantion.service.dto.EquationDTO;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/equation", method = RequestMethod.POST)
    public String calcSubmit(@ModelAttribute EquationDTO equantion, Model model) {
        model.addAttribute("equation", solution.doSolution(equantion));
        model.addAttribute("saved", "All saved");
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
        model.addAttribute("equantion", new EquationDTO());
        return "equantion";
    }
}
