package com.squareequantion.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * dto class for Equation
 * @author Created by Yurii Zub on 5/25/2019.
 * @version 1.0.0
 */
public class EquationDTO {
    @Null
    private int id;
    @NotNull
    @Size(min = 1, max = 15)
    private double paramA;
    @NotNull
    @Size(min = 1, max = 15)
    private double paramB;
    @NotNull
    @Size(min = 1, max = 15)
    private double paramC;
    @Null
    private double discriminant;
    @Null
    private Double firstResult;
    @Null
    private Double secondResult;
    @Null
    private int successResult;

    public EquationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getParamA() {
        return paramA;
    }

    public void setParamA(double paramA) {
        this.paramA = paramA;
    }

    public double getParamB() {
        return paramB;
    }

    public void setParamB(double paramB) {
        this.paramB = paramB;
    }

    public double getParamC() {
        return paramC;
    }

    public void setParamC(double paramC) {
        this.paramC = paramC;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }

    public Double getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Double firstResult) {
        this.firstResult = firstResult;
    }

    public Double getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(Double secondResult) {
        this.secondResult = secondResult;
    }

    public int getSuccessResult() {
        return successResult;
    }

    public void setSuccessResult(int successResult) {
        this.successResult = successResult;
    }

    @Override
    public String toString() {
        return "EquationDTO{" +
                "id=" + id +
                ", paramA=" + paramA +
                ", paramB=" + paramB +
                ", paramC=" + paramC +
                ", discriminant=" + discriminant +
                ", firstResult=" + firstResult +
                ", secondResult=" + secondResult +
                ", successResult=" + successResult +
                '}';
    }
}
