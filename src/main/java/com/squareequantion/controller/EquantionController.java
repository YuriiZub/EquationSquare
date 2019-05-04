package com.squareequantion.controller;

import com.squareequantion.service.EquationService;
import com.squareequantion.service.EquationSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.squareequantion.model.EquantionsEntity;

/**
 * @author Yurii Zub
 * @version 1.1.2
 */
@Controller
public class EquantionController {
    @Autowired
    ApplicationContext context;
   /*Commented, because some problems with configuration*/
    // @Autowired
    // private EquationRepository equationRepository; //Repository
    // @Autowired
    // private EquationSolutionImpl solution;//Solution for calculation

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
    @RequestMapping(value = "/equation", method = RequestMethod.POST)
    public String calcSubmit(@ModelAttribute EquantionsEntity equantion, Model model) {

        EquationSolution solutionBean = context.getBean(EquationSolution.class);
        System.out.println("From post = " + equantion.toString());
        //EquationService serviceBean = context.getBean(EquationService.class);
        model.addAttribute("saved", "Some problems!");
        solutionBean.setResult(equantion);
        solutionBean.doSolution();
        // serviceBean.save(equantion);
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
    @RequestMapping(value = "/equantion", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("saved", "");
        model.addAttribute("equantion", new EquantionsEntity());
        return "equantion";
    }
}
