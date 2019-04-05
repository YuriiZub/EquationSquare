package com.squareequantion.controller;

import com.squareequantion.repository.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.EquationSolution;

/**
 * @author Yurii Zub
 * @version 1.0.1
 */
@Controller
public class EquantionController {

    @Autowired
    private EquationRepository equationRepository; //Repository
    @Autowired
    private EquationSolution solution;//Solution for calculation

    /**
     * Getting of my page
     *
     * @param model model
     * @return return's of main page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        return "index";
    }

    /**
     * Submit data for calculation
     *
     * @param equantion source data
     * @param model     model
     * @return return's of results
     */
    @RequestMapping(value = "/equantion", method = RequestMethod.POST)
    public String calcSubmit(@ModelAttribute EquantionsEntity equantion, Model model) {
        solution.setResult(equantion);
        solution.doSolution();
        equationRepository.save(equantion);
        model.addAttribute("saved", "All saved");
        model.addAttribute("equantion", equantion);
        return "results";
    }

    /**
     * Page for showing calculated data
     *
     * @param model model
     * @return return's page with calculation
     */
    @RequestMapping(value = "/equantion", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("saved", "");
        model.addAttribute("equantion", new EquantionsEntity());
        return "equantion";
    }
}
