package com.squareequantion.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Entity for equantion square
 *
 * @author Yurii Zub
 * @version 1.0.1
 */
@Entity
@Table(name = "equantions")
public class EquantionsEntity {
    private int id;
    private double paramA;
    private double paramB;
    private double paramC;
    private double discriminant;
    private Double firstResult;
    private Double secondResult;
    private int successResult;

    public EquantionsEntity() {
    }


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "param_a", nullable = false, precision = 0)
    public double getParamA() {
        return paramA;
    }

    public void setParamA(double paramA) {
        this.paramA = paramA;
    }

    @Basic
    @Column(name = "param_b", nullable = false, precision = 0)
    public double getParamB() {
        return paramB;
    }

    public void setParamB(double paramB) {
        this.paramB = paramB;
    }

    @Basic
    @Column(name = "param_c", nullable = false, precision = 0)
    public double getParamC() {
        return paramC;
    }

    public void setParamC(double paramC) {
        this.paramC = paramC;
    }

    @Basic
    @Column(name = "discriminant", nullable = false, precision = 0)
    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }

    @Basic
    @Column(name = "first_result", nullable = true, precision = 0)
    public Double getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Double firstResult) {
        if (firstResult == null) firstResult = 0.0;
        this.firstResult = firstResult;
    }

    @Basic
    @Column(name = "second_result", nullable = true, precision = 0)
    public Double getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(Double secondResult) {
        this.secondResult = secondResult;
    }

    @Basic
    @Column(name = "success_result", nullable = false, precision = 0)
    public double getSuccessResult() {
        return successResult;
    }

    public void setSuccessResult(int successResult) {
        this.successResult = successResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquantionsEntity that = (EquantionsEntity) o;
        return id == that.id &&
                Double.compare(that.paramA, paramA) == 0 &&
                Double.compare(that.paramB, paramB) == 0 &&
                Double.compare(that.paramC, paramC) == 0 &&
                Double.compare(that.discriminant, discriminant) == 0 &&
                Double.compare(that.successResult, successResult) == 0 &&
                Objects.equals(firstResult, that.firstResult) &&
                Objects.equals(secondResult, that.secondResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EquantionsEntity{" +
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
