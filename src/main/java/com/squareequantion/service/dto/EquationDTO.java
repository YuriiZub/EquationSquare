package com.squareequantion.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * dto class for Equation
 *
 * @author Created by Yurii Zub on 5/25/2019.
 * @version 1.1.0
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquationDTO)) return false;

        EquationDTO that = (EquationDTO) o;

        if (getId() != that.getId()) return false;
        if (Double.compare(that.getParamA(), getParamA()) != 0) return false;
        if (Double.compare(that.getParamB(), getParamB()) != 0) return false;
        return Double.compare(that.getParamC(), getParamC()) == 0;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "EquationDTO{" +
                "id=" + id +
                ", paramA=" + paramA +
                ", paramB=" + paramB +
                ", paramC=" + paramC +
                '}';
    }
}
