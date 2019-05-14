package com.squareequantion.service;

import com.squareequantion.model.EquantionsEntity;
import org.springframework.stereotype.Service;

/**
 * Solution for solving of square equantion
 *
 * @author Yurii Zub
 * @version 1.1.3
 */

@Service("equationSolution")
public class EquationSolutionImpl implements EquationSolution {

    private EquantionsEntity result;//Parameters of input and results here

    public EquationSolutionImpl() {

    }

    /**
     * Setter for set source data for calculation
     *
     * @param result source data setter
     */
    public void setResult(EquantionsEntity result) {
        this.result = result;
    }

    /**
     * Method for doing of calculation
     */
    public void doSolution() {
        /*calculation of descriminante*/
        double a = this.result.getParamA();
        double b = this.result.getParamB();
        double c = this.result.getParamC();

        if (a != 0) {
            double D = b * b - 4 * a * c;
        /*Equantion has two results x1 and x2*/
            if (D > 0) {
                double x1, x2;
                x1 = (-b - Math.sqrt(D)) / (2 * a);
                x2 = (-b + Math.sqrt(D)) / (2 * a);
                this.setResult(a, b, c, D, x1, x2, 2);
            }
        /*Equantion has one results x1 */
            else if (D == 0) {
                double x1;
                x1 = -b / (2 * a);
                this.setResult(a, b, c, D, x1, 0, 1);
            }
        /*Equantion has not any results*/
            else {
                this.setResult(a, b, c, D, 0, 0, 0);
            }
        }
        /*First parameter is zero value*/
        else {
            this.setResult(a, b, c, 0, 0, 0, -1);
        }

    }

    /**
     * Setter for all result data after calculation
     *
     * @param a       first source parameter
     * @param b       second source parameter
     * @param c       third source parameter
     * @param D       Discriminant
     * @param X1      First result
     * @param X2      Second result
     * @param success Sucess flag of calculation 0 - are no results
     *                1 - is one results 2 - is two results
     */

    private void setResult(double a, double b, double c, double D, double X1, double X2, int success) {
        this.result.setParamA(a);
        this.result.setParamB(b);
        this.result.setParamC(c);
        this.result.setDiscriminant(D);
        this.result.setFirstResult(X1);
        this.result.setSecondResult(X2);
        this.result.setSuccessResult(success);
    }

    /**
     * Getter for results
     *
     * @return Return's result of source data and calculation result
     */
    public EquantionsEntity getResult() {
        return this.result;
    }

}
