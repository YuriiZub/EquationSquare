package com.squareequation.controller;

import com.squareequation.service.solution.EquationSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.squareequation.service.dto.EquationDTO;

import javax.servlet.http.HttpServletRequest;


/**
 * Main controller of Equation application
 *
 * @author Yurii Zub
 * @version 1.2.1
 */
@Controller
public class EquationController {

    @Autowired
    EquationSolution solution;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMainPage(Model model, HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "/equation", method = RequestMethod.POST)
    public String showCalculationResults(@ModelAttribute EquationDTO equationdto, Model model) throws  Exception{
        model.addAttribute("equation", solution.calculateEquation(equationdto));
        model.addAttribute("saved", "All saved");
        return "results";
    }

    @RequestMapping(value = "/equation", method = RequestMethod.GET)
    public String showEnterForm(Model model, HttpServletRequest request) {
        String pagename = request.getRequestURL().toString();
        model.addAttribute("pagename", pagename);
        model.addAttribute("saved", "");
        model.addAttribute("equationdto", new EquationDTO());
        return "equation";
    }


}
