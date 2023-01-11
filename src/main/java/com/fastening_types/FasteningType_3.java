package com.fastening_types;

import com.OptionPanes;

public class FasteningType_3 extends FasteningType {

    public FasteningType_3(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }


    @Override
    double calculateRay() {
        ray = (-rcy) + (q1*ab);
        return ray;
    }

    @Override
    double calculateRcy() {
        rcy = (-(0.5*q1*ab))/2;
        return rcy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ray*x;
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x1 = (x-ab);
        mg = (ray*x) - ((q1*x1*x1)/2);
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x2 = (x-(2*ab));
        mg = formulaMgBC(x) + (rcy*x2) + ((q1*x2*x2)/2);
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = ray;
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = ray - (q1*(x-ab));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = ray - (q1*ab) + rcy;
        return t;
    }

    @Override
    double calculateCAB() {
        cAB = ((39*q1*ab*ab*ab)/48);
        return cAB;
    }

    @Override
    double calculateCBC() {
        cBC = cAB;
        return cBC;
    }

    @Override
    double calculateCCD() {
        cCD = cAB;
        return cCD;
    }

    @Override
    double formulaYAB(double x) {
        double y;
        y = (-((ray*x*x*x)/6));
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x - ab);
        y = ((q1*x2*x2*x2*x2)/24) + formulaYAB(x);
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x2 = (x - (2*ab));
        y = formulaYBC(x) + ((rcy*x2*x2*x2)/6) - ((q1*x2*x2*x2*x2)/24);
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0){return false;}
        else{return true;}
    }

    @Override
    public void beforeCalculationAssignment() {
        this.values[11] = this.values[10];
        this.values[12] = this.values[10];
    }

    @Override
    public boolean[] isYZero() {
        //                     A     B     C     D     E     F
        return new boolean[]{true,false,true,false,false,false};
    }

    @Override
    public void calculator() {
        calculateRcy();
        calculateRay();

    }
}